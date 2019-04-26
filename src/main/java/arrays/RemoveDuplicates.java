package arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = null;
        /*
         */
        nums = new int[]{1, 1, 2, 3};
        System.out.println("len: 3 - " + removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1};
        System.out.println("len: 1 - " + removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 2, 2, 4, 6, 6, 7};
        System.out.println("len: 5 - " + removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{};
        System.out.println("len: 0 - " + removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));


        nums = new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9};
        System.out.println("len: 9 - " + removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}
