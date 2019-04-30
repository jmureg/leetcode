package trees;

import java.util.ArrayList;

public class ValidateBinarySearchTree {

    ValidateBinarySearchTree() {

    }

    public static void main(String[] args) {
        ValidateBinarySearchTree val = new ValidateBinarySearchTree();


        TreeNode root = null;


        root = new TreeNode(1);

        TreeNode onex = new TreeNode(1);
        root.left = onex;

        System.out.println(isValidBST(root));
        System.out.println(val.isValid(root));
        System.out.println();


        root = new TreeNode(2);

        TreeNode nine = new TreeNode(1);
        TreeNode twenty = new TreeNode(3);
        root.left = nine;
        root.right = twenty;

        System.out.println(isValidBST(root));
        System.out.println(val.isValid(root));
        System.out.println();


        root = new TreeNode(5);

        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        root.left = one;
        root.right = four;

        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);

        twenty.left = three;
        twenty.right = six;

        System.out.println(isValidBST(root));
        System.out.println(val.isValid(root));
        System.out.println();

    }

    public static boolean isValidBST(TreeNode root) {
        ArrayList<Integer> treenodes = inorder(root);
        return validateBinaryTree(treenodes);
    }

    private static ArrayList<Integer> inorder(TreeNode root) {
        ArrayList<Integer> cache = new ArrayList<>();
        if (root == null) {
            return cache;
        } else if (root.left == null && root.right == null) {
            cache.add(root.val);
            return cache;
        } else {
            cache.addAll(inorder(root.left));
            cache.add(root.val);
            cache.addAll(inorder(root.right));
        }
        return cache;
    }

    private static boolean validateBinaryTree(ArrayList<Integer> treenodes) {
        if (treenodes == null || treenodes.size() == 1) {
            return true;
        }
        for (int i = 1; i < treenodes.size(); i++) {
            if (treenodes.get(i - 1) >= treenodes.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(TreeNode root) {
        if (root == null) {
            return true;
        } else if ((root.left == null) || (root.left != null && root.left.val < root.val) && (root.right == null) || (root.right != null && root.right.val > root.val)) {
            return isValidBST(root.left) && isValidBST(root.right);
        }
        return false;
    }
}
