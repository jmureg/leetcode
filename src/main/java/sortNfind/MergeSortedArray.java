package sortNfind;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = null;
        nums1 = null;
        int m = -1;
        int[] nums2 = null;
        int n = -1;

        nums1 = new int[]{2,0};
        m = 1;
        nums2 = new int[]{1};
        n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,0,0,0};
        m = 3;
        nums2 = new int[]{4,5,6};
        n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,0,0,0};
        m = 3;
        nums2 = new int[]{2,5,6};
        n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2==null) {
            return;
        }

        if(nums1!=null && nums1.length>0 && m==0 && n==1) {
            nums1[0] = nums2[0];
        }

        int n1 = m-1;

        int n2 = n-1;

        int counter = n+m-1;
        while(n1>-1 && n2>-1) {
            if(nums1[n1]>nums2[n2]) {
                nums1[counter--] = nums1[n1--];
            } else {
                nums1[counter--] = nums2[n2--];
            }
        }
        while(n2>-1) {
            nums1[counter--] = nums2[n2--];
        }
    }
}
