package trees;


public class BinaryTreeNode {

    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setLeft(BinaryTreeNode l) {
        this.left = l;
    }

    public void setRight(BinaryTreeNode r) {
        this.right = r;
    }

    public int getValue() {
        return this.value;
    }

    public BinaryTreeNode getRight() {
        return this.right;
    }

    public BinaryTreeNode getLeft() {
        return this.left;
    }
}
