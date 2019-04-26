package trees;

import java.util.ArrayList;

public class SymmetricTree {
    public static void main(String[] args) {

        TreeNode root = null;
        System.out.println(isSymmetric(root));


        root = new TreeNode(1);

        TreeNode onex = new TreeNode(2);
        root.left = onex;

        System.out.println(isSymmetric(root));


        root = new TreeNode(2);

        TreeNode nine = new TreeNode(1);
        TreeNode twenty = new TreeNode(3);
        root.left = nine;
        root.right = twenty;

        System.out.println(isSymmetric(root));


        root = new TreeNode(5);

        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        root.left = one;
        root.right = four;

        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);

        twenty.left = three;
        twenty.right = six;

        System.out.println(isSymmetric(root));
    }

    /*
    recursive
     */
    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    /*
    iterative
     */
    public static boolean isSymmetric2(TreeNode root) {
        ArrayList<Integer> treenodes = postorder(root);
        return isSymmetricBinaryTree(treenodes);

    }

    private static ArrayList<Integer> postorder(TreeNode root) {
        ArrayList<Integer> cache = new ArrayList<>();
        if (root == null) {
            return cache;
        } else if (root.left == null && root.right == null) {
            cache.add(root.val);
            return cache;
        } else {
            cache.add(root.val);
            cache.addAll(postorder(root.left));
            cache.addAll(postorder(root.right));
        }
        return cache;
    }

    private static boolean isSymmetricBinaryTree(ArrayList<Integer> treenodes) {
        if (treenodes == null || treenodes.size() == 0 || treenodes.size() == 1) {
            return true;
        }

        int current_position = 0;
        int max_position = 0;
        int counter = 0;

        while (Math.pow(2, counter) <= treenodes.size()) {
            max_position = (int) Math.pow(2, counter);
            if (!checkPalindrom(treenodes, current_position, max_position)) {
                return false;
            }
            counter++;
            current_position = (int) Math.pow(2, counter);
        }
        counter++;
        max_position = (int) Math.pow(2, counter);
        return checkPalindrom(treenodes, current_position, max_position);
    }

    private static boolean checkPalindrom(ArrayList<Integer> treenodes, int current_position, int max_position) {
        if (current_position == max_position || max_position - current_position == 1) {
            return (treenodes.get(current_position) == treenodes.get(max_position));
        } else if (current_position < max_position || current_position == max_position) {
            if (treenodes.get(current_position) == treenodes.get(max_position)) {
                current_position++;
                max_position++;
                return checkPalindrom(treenodes, current_position, max_position);
            }
        }
        return false;
    }
}
