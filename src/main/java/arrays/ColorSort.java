package arrays;

import java.util.Arrays;

public class ColorSort {

    public ColorSort() {

    }

    public static void main(String[] args) {

        ColorSort cs = new ColorSort();
        int[] nums = null;
        int[] result = null;


        nums = new int[]{0,2,2,2,0,2,1,1};
        cs.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2,0,2,1,1,0};
        cs.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0,2,1,0,0,0,0,2};
        cs.sortColors(nums);
        System.out.println(Arrays.toString(nums));


        nums = new int[]{0,2,1};
        cs.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,0};
        cs.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2,0};
        cs.sortColors(nums);
        System.out.println(Arrays.toString(nums));



        nums = new int[]{2,0,2,1,1,0,2,1,0,0,0,2,1,0};
        cs.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        int first0 = -1;
        int first1 = -1;
        int first2 = -1;

        switch (nums[0]) {
            case 0:
                first0++;
                break;
            case 1:
                first1++;
                break;
            case 2:
                first2++;
                break;
        }

        for (int i=1; i<nums.length; i++) {
            int prev = nums[i-1];
            int current = nums[i];

            if(prev>current) {
                if (current == 0) {
                    if (prev == 1 && first1 > -1) {
                        swap(nums, i, first1);
                        first0=first1;
                        first1++;
                    } else if (prev == 1) {

                    } else if (prev == 2 && first1 > -1&& first2 > -1) {
                        swap(nums, i, first1);
                        swap(nums, i, first2);
                        first1++;
                        first2++;
                    } else if (prev == 2 && first2 > -1) {
                        swap(nums, i, first2);
                        first0=first2;
                        first2++;
                    }
                } else if (current == 1) {
                    if (prev == 2 && first2 > -1) {
                        swap(nums, i, first2);
                        if(first1==-1) {
                            first1=first2;
                        }
                        first2++;

                    } else if (prev == 2 && first1 > -1) {
                        swap(nums, i, first1);
                        first2++;
                    } else if (prev == 2) {
                        swap(nums, i, first2);
                        first1=first2;
                        first2++;
                    }
                } else if (current == 2) {
                    first2 = i;
                }
            } else if(current==0 && first0==-1) {
                first0=i;
            } else if (current==1 && first1==-1) {
                first1=i;
            } else if (current==2 && first2==-1) {
                first2=i;
            }
        }
    }

    private void swap(int[] nums, int num1, int num2) {
        int tmp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2]= tmp;
    }
}
