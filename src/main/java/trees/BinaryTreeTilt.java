package trees;

/*
https://leetcode.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {
    private int totalTilt = 0;

    public static void main(String[] args) {
        BinaryTreeTilt btt = new BinaryTreeTilt();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left=two;
        one.right=three;
        //btt.print(one, 0);
        int result = btt.findTilt(one);
        System.out.println("result: " + result);

        //example 2
        btt = new BinaryTreeTilt();
        TreeNode four = new TreeNode(4);
        two = new TreeNode(2);
        three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode nine = new TreeNode(9);
        TreeNode seven = new TreeNode(7);

        four.left=two;
        four.right=nine;

        two.left=three;
        two.right=five;

        nine.right=seven;

        //btt.print(four, 0);
        result = btt.findTilt(four);
        System.out.println("result: " + result);

    }

    public int findTilt(TreeNode root) {
        this.totalTilt = 0;
        this.valueSum(root);
        return this.totalTilt;
    }

    private int valueSum(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = this.valueSum(node.left);
        int rightSum = this.valueSum(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        this.totalTilt += tilt;

        return node.val + leftSum + rightSum;
    }
}
