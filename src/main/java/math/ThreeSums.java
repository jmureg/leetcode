package math;

import java.util.ArrayList;
import java.util.List;

public class ThreeSums {
    public static void main(String[] args) {

        List<List<Integer>> result = null;

        //result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        //System.out.println(result.toString());

        result = threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});

        System.out.println(result.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        for (int a = 0; a < nums.length - 2; a++) {
            for (int b = 1; b < nums.length - 1; b++) {
                if (a == b) {
                    continue;
                }
                for (int c = 2; c < nums.length; c++) {
                    if (b == c || a == c) {
                        continue;
                    }
                    if (nums[a] + nums[b] + nums[c] == 0 && isNew(nums[a], nums[b], nums[c], result)) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isNew(int a, int b, int c, ArrayList<List<Integer>> result) {
        for (List<Integer> list : result
        ) {
            List<Integer> clone = new ArrayList<>();
            for (int number : list
            ) {
                clone.add(number);
            }
            int apos = clone.indexOf(a);

            if (a == b && apos > -1) {
                List<Integer> sublist = clone;
                sublist.remove(apos);
                int bpos = sublist.indexOf(b);
                if (bpos > -1) {
                    sublist.remove(bpos);
                    int cpos = sublist.indexOf(c);
                    if (cpos > -1) {
                        return false;
                    }
                }
            } else if (list.contains(a) && list.contains(b) && list.contains(c)) {
                return false;
            }

        }
        return true;
    }
}
