package arrays;

/*
https://leetcode.com/problems/toeplitz-matrix/
Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.


 */
public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = null;
        ToeplitzMatrix tm = new ToeplitzMatrix();

        matrix = new int[][]{{11,74,0,93},{40,11,74,7}};
        System.out.println("0. false: " + tm.isToeplitzMatrix(matrix));

        matrix = new int[][]{{1,2,3,4},{5,1,2,3}, {9,5,1,2}};
        System.out.println("1. true: " + tm.isToeplitzMatrix(matrix));

        matrix = new int[][]{{1,2},{2,2}};
        System.out.println("2. false: " + tm.isToeplitzMatrix(matrix));

        matrix = new int[][]{{1,2},{2,1}};
        System.out.println("3. true: " + tm.isToeplitzMatrix(matrix));

        matrix = new int[][]{{}};
        System.out.println("4. true: " + tm.isToeplitzMatrix(matrix));

    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}
