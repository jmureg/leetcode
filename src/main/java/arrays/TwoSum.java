package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] digits = null;
        int[] result = null;


        digits = new int[]{1,1};
        result = twoSums(digits, 2);
        System.out.println("[0,1] = " + Arrays.toString(result));

        digits = new int[]{2, 7, 11, 15};
        result = twoSums(digits, 9);
        System.out.println("[2,7] = " + Arrays.toString(result));

        digits = new int[]{2, 7, 11, 15};
        result = twoSums(digits, 18);
        System.out.println("[7, 11] = " + Arrays.toString(result));
    }

    public static int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();

        for(int n=0; n<nums.length; n++) {
            int missing = target-nums[n];
            if(cache.containsKey(missing)) {
                int pos = cache.get(missing);
                return new int[]{pos, n};
            } else {
                cache.put(nums[n], n);
            }
        }
        return new int[]{};
    }
}
