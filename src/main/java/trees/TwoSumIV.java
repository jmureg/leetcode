package trees;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoSumIV {
    TwoSumIV() {
    }

    public static void main(String[] args) {
        TwoSumIV ts = new TwoSumIV();

        TreeNode root = new TreeNode(5);

        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        root.left = three;
        root.right = seven;

        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        three.left = two;
        three.right = four;


        TreeNode six = new TreeNode(6);
        TreeNode eight = new TreeNode(8);

        seven.left = three;
        seven.right = six;

        System.out.println("true: " + ts.findTarget(root, 7));
        System.out.println("false: " + ts.findTarget(root, 1));
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        Set<Integer> cache = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                int currentValue = root.val;
                if (cache.contains(k - currentValue)) {
                    System.out.println("Found pair: " + currentValue + " and " + (k - currentValue));
                    return true;
                }
                stack.push(root);
                cache.add(currentValue);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return false;
    }
}
