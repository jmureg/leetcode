package math;

import java.util.Arrays;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/722/

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.


 */
public class FindMissingNumber {

    FindMissingNumber() {
    }

    public int missingNumber(int[] nums) {
        int[] register = new int[nums.length + 1];
        Arrays.fill(register, 0);

        for (int number : nums
        ) {
            register[number] = 1;
        }

        for (int i = 0; i < register.length; i++) {
            if (register[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindMissingNumber fmn = new FindMissingNumber();
        int[] nums = null;

        nums = new int[]{0, 1, 2, 4};
        System.out.println(Arrays.toString(nums) + fmn.missingNumber(nums));

        nums = new int[]{3, 0, 1};
        System.out.println(Arrays.toString(nums) + fmn.missingNumber(nums));

        nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(Arrays.toString(nums) + fmn.missingNumber(nums));
    }
}
