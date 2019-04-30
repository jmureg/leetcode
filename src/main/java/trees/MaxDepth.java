package trees;

public class MaxDepth {
    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(3);

        BinaryTreeNode nine = new BinaryTreeNode(9);
        BinaryTreeNode twenty = new BinaryTreeNode(20);
        root.setLeft(nine);
        root.setRight(twenty);

        BinaryTreeNode fifteen = new BinaryTreeNode(15);
        BinaryTreeNode seven = new BinaryTreeNode(7);

        twenty.setLeft(fifteen);
        twenty.setRight(seven);

        System.out.println(maxDepth1(root));
    }

    public static int maxDepth1(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(1 + maxDepth1(root.getRight()), 1 + maxDepth1(root.getLeft()));
        }
    }

    private static int max(int a, int b) {
        if (a < b) {
            return b;
        } else return a;
    }
}
