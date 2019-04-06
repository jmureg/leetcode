package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = null;
        System.out.println(levelOrder(root));


        root = new TreeNode(2);

        TreeNode nine = new TreeNode(1);
        TreeNode twenty = new TreeNode(3);
        root.left = nine;
        root.right = twenty;

        System.out.println(levelOrder(root));


        root = new TreeNode(1);

        TreeNode onex = new TreeNode(2);
        root.left = onex;

        System.out.println(levelOrder(root));




        root = new TreeNode(5);

        TreeNode one= new TreeNode(1);
        TreeNode four = new TreeNode(4);
        root.left = one;
        root.right = four;

        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);

        four.left = three;
        four.right = six;

        System.out.println(levelOrder(root));
    }

    /*
    iterative
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<Integer> treenodes = postorder(root);
        return orderInLevels(treenodes);
    }

    private static List<List<Integer>> orderInLevels(ArrayList<Integer> treenodes) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(treenodes==null || treenodes.size()==0 || treenodes.size()==1) {
            return result;
        }

        int current_position = 0;
        int delta;
        int counter = 0;

        while(current_position<treenodes.size()-1) {
            delta = (int)Math.pow(2,counter);
            List<Integer> level = createLevel(treenodes, current_position, current_position+delta);
            result.add(level);
            counter++;
            current_position += level.size();
            delta = (int) Math.pow(2,counter);
        }

        List<Integer> lastLevel = new ArrayList<>();
        for(int n=current_position; n<=treenodes.size()-1; n++) {
            lastLevel.add(treenodes.get(n));
        }
        if(lastLevel.size()>0) {
            result.add(lastLevel);
        }
/*
        counter++;
        delta = (int)Math.pow(2,counter);

        //add last set
        List<Integer>lastLevel = createLevel(treenodes, ++current_position, treenodes.size());
        if(lastLevel.size()>0) {
            result.add(lastLevel);
        }
*/
        return result;
    }

    private static List<Integer>  createLevel(ArrayList<Integer> treenodes, int current_position, int delta) {
        List<Integer> level = new ArrayList<>();
        for(int i=current_position; i<delta; i++) {
            level.add(treenodes.get(i));
        }
        return level;
    }

    private static ArrayList<Integer> postorder(TreeNode root) {
        ArrayList<Integer> cache = new ArrayList<>();
        if(root==null) {
            return cache;
        } else if(root.left==null && root.right==null) {
            cache.add(root.val);
            return cache;
        } else {
            cache.add(root.val);
            cache.addAll(postorder(root.left));
            cache.addAll(postorder(root.right));
        }
        return cache;
    }
}
