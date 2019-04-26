package arrays;


import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = null;
        int[] nums2 = null;

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        int[] result = intersect(nums1, nums2);
        System.out.println("[4,9] = " + result);


        nums1 = new int[]{1};
        nums2 = new int[]{1};
        result = intersect(nums1, nums2);
        System.out.println("[1] = " + result);


        nums1 = new int[]{4, 5, 6, 8};
        nums2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        result = intersect(nums1, nums2);
        System.out.println("[4, 5, 6] = " + result);

        System.out.println("fin.");
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        } else {
            if (nums1.length >= nums2.length) {
                for (int x : nums1
                ) {
                    big.add(x);
                }
                for (int y : nums2
                ) {
                    small.add(y);
                }
            } else {
                for (int x : nums1
                ) {
                    small.add(x);
                }
                for (int y : nums2
                ) {
                    big.add(y);
                }
            }

            for (int s : small
            ) {
                for (int b : big
                ) {
                    if (b == s) {
                        result.add(b);
                        big.remove((Integer) b);
                        break;
                    }
                }
            }
        }

        int[] res = new int[result.size()];
        int i = 0;
        for (int x : result
        ) {
            res[i++] = x;
        }
        return res;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        int[] big = null;
        int[] small = null;
        List<Integer> result = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        } else {
            if (nums1.length >= nums2.length) {
                big = nums1;
                small = nums2;
            } else {
                big = nums2;
                small = nums1;
            }

            for (int i = 0; i < nums1.length; i++) {
                List<Integer> current = new ArrayList<>();
                int m = i;
                int n = 0;
                while (big[m] == small[n]) {
                    current.add(big[m]);
                    if (big.length - 1 > m && small.length - 1 > n) {
                        m++;
                        n++;
                    } else {
                        break;
                    }
                }
                if (current.size() > result.size()) {
                    result = current;
                }
            }
        }

        int[] res = new int[result.size()];
        int i = 0;
        for (int x : result
        ) {
            res[i++] = x;
        }
        return res;
    }
}
