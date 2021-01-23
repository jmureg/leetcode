package arrays;

import java.util.Arrays;

/*
https://leetcode.com/problems/reshape-the-matrix/

In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */
public class ReshapeMatrix {
    public static void main(String[] args) {
        ReshapeMatrix rm = new ReshapeMatrix();
        int[][] nums = null;

        nums = new int[][]{{1,2},{3,4}};
        System.out.println("2. I:");
        rm.print(nums);
        System.out.println("2. O:");
        rm.print(rm.matrixReshape(nums, 4,1));

        System.out.println("");

        nums = new int[][]{{1,2},{3,4}};
        System.out.println("2. I:");
        rm.print(nums);
        System.out.println("2. O:");
        rm.print(rm.matrixReshape(nums, 2,4));

        System.out.println("");

        nums = new int[][]{{1,2},{3,4}};
        System.out.println("2. I:");
        rm.print(nums);
        System.out.println("2. O:");
        rm.print(rm.matrixReshape(nums, 1,4));

        System.out.println("");

        nums = new int[][]{{}};
        System.out.println("1. I:");
        rm.print(nums);
        System.out.println("1. O:");
        rm.print(rm.matrixReshape(nums, 1,4));

        System.out.println("");

        nums = new int[][]{{1,2},{3,4}};
        System.out.println("3. I:");
        rm.print(nums);
        System.out.println("3. O:");
        rm.print(rm.matrixReshape(nums, 2,4));
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums==null || r*c>(nums.length*nums[0].length)) {
            return nums;
        }
        int[][] reshapedMatrix = new int[r][c];
        int rowCounter = 0;
        int columnCounter = 0;
        for (int rr = 0; rr < nums.length; rr++) {
            for (int cc = 0; cc < nums[0].length; cc++) {
                if(columnCounter<c) {
                    reshapedMatrix[rowCounter][columnCounter++] = nums[rr][cc];
                } else {
                    columnCounter = 0;
                    rowCounter++;
                    reshapedMatrix[rowCounter][columnCounter++] = nums[rr][cc];
                }
            }
        }
        return reshapedMatrix;
    }

    public void print(int[][] nums) {
        for (int[] line:nums
             ) {
            System.out.println(Arrays.toString(line));
        }
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        if((r == nums.length && c == nums[0].length) || r*c > (nums.length*nums[0].length))
            return nums;

        int ans[][] = new int[r][c];

        int i = 0, j = 0, k = 0, l = 0;
        while(i < nums.length){
            ans[k][l] = nums[i][j];
            j++;
            l++;
            if(j == nums[0].length){
                j = 0;
                i++;
            }
            if(l == c){
                l = 0;
                k++;
            }
        }
        return ans;
    }
}
