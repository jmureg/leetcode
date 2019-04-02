package sortNfind;

import java.util.*;

/*
Find pairs of integers that sum to X
*/
public class TwoSums {
    public static void main(String[] args) {
        int[] values = new int[]{2, 7, 11, 15};
        values = new int[]{3,2,4};
        int x = 6;
        int[] result = twoSum(values, x);
        if(result!=null && result.length==2){
            System.out.println("Solutions found in (" + result[0] + "," + result[1] + ")");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<Integer>() {};
        for(int i=0; i<nums.length; i++) {
            if(list.contains(target-nums[i])) {
                return new int[]{list.indexOf(target-nums[i]), i};
            } else {
                list.add(nums[i]);
            }
        }
        return null;
    }
}
