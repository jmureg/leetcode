package dynamicProgramming;

import java.util.Arrays;

public class SubmatrixWithSumK {
    public static void main(String[] args) {
        SubmatrixWithSumK smwsk = new SubmatrixWithSumK();
        int[][] matrix = null;
        int[][] result = null;
        int k = -1;

        matrix = new int[][]{new int[]{4, -5, 3, 6, -1, -3}};
        k = 9;
        //int[] entry = new int[]{4, -5, 3, 6, -1, -3};
        //smwsk.maxSubArray2(entry);
        result = smwsk.subMatrixWithSumK(matrix, k);
        System.out.println("Computed [" + Arrays.toString(result) + "] with k=" + k);

        matrix = new int[][]{new int[]{4, 5}, new int[]{1, 2}};
        k = 7;
        result = smwsk.subMatrixWithSumK(matrix, k);
        System.out.println("Computed [" + Arrays.toString(result) + "] with k=" + k);


        matrix = new int[][]{new int[]{0, 1, -3, -4, 5}, new int[]{0, 6, 3, 4, 1}, new int[]{2, -2, -1, 4, 5}, new int[]{-3, 3, 1, 0, 3}};
        k = 18;
        result = smwsk.subMatrixWithSumK(matrix, k);
        System.out.println("Computed [" + Arrays.toString(result) + "] with k=" + k);
    }

    public int[] maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }

        int curMax = nums[0];
        int allMax = nums[0];
        nums[nums.length - 1] = 0;
        nums[nums.length - 2] = 0;
        for (int i = 1; i < nums.length - 2; i++) {
            if (nums[i] > curMax + nums[i]) {
                curMax = nums[i];
                nums[nums.length - 2] = i - 1;
            } else {
                curMax = curMax + nums[i];
                //nums[nums.length-1] = i;
                nums[nums.length - 2] = i;
            }
            if (allMax < curMax) {
                allMax = curMax;
            }
        }

        return nums;
    }


    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int curMax = nums[0];
        int allMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            allMax = Math.max(allMax, curMax);
        }
        return allMax;
    }

    public int[][] subMatrixWithSumK(int[][] matrix, int k) {
        if (matrix == null) {
            return null;
        }
        int[] stats = new int[matrix.length + 2];
        int currentSum = 0;

        int[][] submatrix = null;

        //find k
        for (int l = 0; l < matrix[0].length; l++) {
            for (int r = l; r < matrix[0].length; r++) {
                currentSum = calculateCurrentSum(matrix, l, r, stats);
                if (currentSum == k) {
                    System.out.println("found curentsum=" + currentSum);

                    stats = maxSubArray(stats);

                    //extract submatrix with sum k
                    int maxUpPos = stats[stats.length - 2];
                    int maxDownPos = stats[stats.length - 1];
                    submatrix = extractSubmatrix(matrix, l, r, maxUpPos, maxDownPos);
                }
            }
        }

        return submatrix;
    }


    private int calculateCurrentSum(int[][] matrix, int l, int r, int[] stats) {
        Arrays.fill(stats, 0); // reset

        for (int y = l; y <= r; y++) {
            for (int x = 0; x < stats.length - 2; x++) {
                stats[x] += matrix[x][y];
            }
        }

        int sum = 0;
        for (int x = 0; x < stats.length - 2; x++) {
            sum += stats[x];
        }

        return sum;
    }

    private int[][] extractSubmatrix(int[][] matrix, int maxLeft, int maxRight, int maxUp, int maxDown) {
        int[][] subMatrix = new int[maxUp - maxDown + 1][maxRight - maxLeft + 1];

        int xx = 0;
        int yy = 0;
        for (int x = maxDown; x <= maxUp; x++) {
            for (int y = maxLeft; y <= maxRight; y++) {
                subMatrix[xx][yy++] = matrix[x][y];
            }
            yy = 0;
            xx++;
        }

        return subMatrix;
    }
}
