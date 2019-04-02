package arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = null;

        nums = new int[]{1,2,3,1};
        System.out.println("true = " + containsDuplicate(nums));

        nums = new int[]{1,2,3,4};
        System.out.println("false = " + containsDuplicate(nums));

        nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println("true = " + containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

        for (int i:nums
             ) {
            if(!cache.containsKey(i)) {
                cache.put(i, 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
