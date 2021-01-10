package arrays;

import java.util.Arrays;

/*
https://leetcode.com/problems/array-partition-i/
 */
public class ArrayPartitionPt1 {
    public int arrayPairSum(int[] nums) {
        if(nums==null) {
            return 0;
        } else if (nums.length==2) {
            return Math.min(nums[0],nums[1]);
        } else {
            Arrays.sort(nums);
            int sum = 0;
            for(int i=0; i<nums.length-1; i=i+2) {
                sum += Math.min(nums[i],nums[i+1]);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        ArrayPartitionPt1 ap = new ArrayPartitionPt1();
        int[] nums = new int[]{1,4,3,2};
        System.out.println(ap.arrayPairSum(nums));

        nums = new int[]{1,4,3,4};
        System.out.println(ap.arrayPairSum(nums));

        nums = new int[]{};
        System.out.println(ap.arrayPairSum(nums));

        nums = new int[]{1,2};
        System.out.println(ap.arrayPairSum(nums));

        nums = new int[]{6,2,6,5,1,2};
        System.out.println(ap.arrayPairSum(nums));
    }
}
