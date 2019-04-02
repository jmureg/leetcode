package recursion;

import trees.BinaryTreeNode;

public class TreeSum {
    public static void main(String[] args) {

        BinaryTreeNode tree = new BinaryTreeNode(2);
        BinaryTreeNode seven = new BinaryTreeNode(7);
        tree.setLeft(seven);

        BinaryTreeNode two = new BinaryTreeNode(2);
        seven.setLeft(two);
        BinaryTreeNode six = new BinaryTreeNode(6);
        seven.setRight(six);

        int values = computeNodeValues(tree);
        System.out.println("Value: " + values);
    }

    public static int computeNodeValues(BinaryTreeNode btn) {
        if (btn == null) {
            return 0;
        } else {
            return btn.getValue() + computeNodeValues(btn.getLeft()) + computeNodeValues(btn.getRight());
        }
    }
}
