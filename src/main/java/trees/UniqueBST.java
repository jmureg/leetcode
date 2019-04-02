package trees;

import lists.ListNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {

    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
        System.out.println(list.size());
    }

    public static List<TreeNode> generateTrees(int n) {
        if(n<1) {
            return new ArrayList<TreeNode>();
        } else {
            return generateTreesHelper(1, n);
        }
    }

    public static List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <=end; i++) {
            left = generateTreesHelper(start, i - 1);
            right = generateTreesHelper(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}