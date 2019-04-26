package arrays;

public class MaximumSumCircularSubarray {
    MaximumSumCircularSubarray() {
    }

    /*
    O(n)
     */
    public int maxSubarraySumCircular(int[] A) {
        int total = 0;
        int maxSum = Integer.MIN_VALUE;
        int curMax = 0;
        int minSum = Integer.MAX_VALUE;
        int curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    /*
        O(n^2)
     */
    public int maxSubarraySumCircular2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] control = new int[A.length];
        int current = Integer.MIN_VALUE;
        int currentMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            current = A[i];
            currentMax = A[i];
            for (int ii = i + 1; ii < A.length; ii++) {
                if (currentMax < current + A[ii]) {
                    currentMax = current + A[ii];
                }
                current += A[ii];

            }
            for (int ii = 0; ii < i - 1; ii++) {
                if (currentMax < current + A[ii]) {
                    currentMax = current + A[ii];
                }
                current += A[ii];
            }
            if (A[i] <= currentMax) {
                control[i] = currentMax;
            }
        }

        max = findMax(control);

        return max;
    }

    private int findMax(int[] control) {
        int max = Integer.MIN_VALUE;
        for (int num : control
        ) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray mscs = new MaximumSumCircularSubarray();
        int[] nums = null;

        nums = new int[]{-1, 3, -3, 9, -6, 8, -5, -5, -6, 10};
        System.out.println("3: " + mscs.maxSubarraySumCircular(nums));


        nums = new int[]{1, -2, 3, -2};
        System.out.println("3: " + mscs.maxSubarraySumCircular(nums));


        nums = new int[]{1, -2, 3, -2, 5};
        System.out.println("7: " + mscs.maxSubarraySumCircular(nums));

        nums = new int[]{3, -1, 2, -1};
        System.out.println("4: " + mscs.maxSubarraySumCircular(nums));

        nums = new int[]{5, -2, 5};
        System.out.println("10: " + mscs.maxSubarraySumCircular(nums));


    }

}
