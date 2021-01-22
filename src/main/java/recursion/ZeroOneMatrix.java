package recursion;

/*
https://leetcode.com/problems/01-matrix/

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
 */

import java.util.Arrays;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        ZeroOneMatrix zom = new ZeroOneMatrix();

        // test 1
        int[][] inputMatrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        int[][] resultMatrix = zom.updateMatrix(inputMatrix);

        System.out.println("input1:");
        zom.print(inputMatrix);

        System.out.println("result:");
        zom.print(resultMatrix);

        // test 2
        inputMatrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};
        resultMatrix = zom.updateMatrix(inputMatrix);

        System.out.println("input2:");
        zom.print(inputMatrix);

        System.out.println("result:");
        zom.print(resultMatrix);

        // test 3
        inputMatrix = new int[][]{
                {0, 0, 1, 1}};
        resultMatrix = zom.updateMatrix(inputMatrix);

        System.out.println("input3:");
        zom.print(inputMatrix);

        System.out.println("result:");
        zom.print(resultMatrix);

        // test 4
        inputMatrix = new int[][]{
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        resultMatrix = zom.updateMatrix(inputMatrix);

        System.out.println("input4:");
        zom.print(inputMatrix);

        System.out.println("result:");
        zom.print(resultMatrix);


    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = null;
        if (matrix == null || matrix.length == 0) {
            return null;
        } else {
            result = new int[matrix.length][matrix[0].length];
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[0].length; y++) {
                    if (matrix[x][y] == 0) {
                        result[x][y] = 0;
                    } else {
                        // 1 + recursion on min(left, right, top, down)
                        boolean[][] checked = new boolean[matrix.length][matrix[0].length];
                        init(checked);
                        checked[x][y] = true;
                        result[x][y] = 1 +
                                Math.min(findClosestZero(matrix, x - 1, y, checked),
                                        Math.min(findClosestZero(matrix, x + 1, y, checked),
                                                Math.min(findClosestZero(matrix, x, y - 1, checked),
                                                        Math.min(findClosestZero(matrix, x, y + 1, checked), Integer.MAX_VALUE))));
                    }
                }
            }
        }
        return result;
    }

    private void init(boolean[][] checked) {
        for (int i = 0; i < checked.length; i++) {
            Arrays.fill(checked[i], false);
        }
    }

    private int findClosestZero(int[][] matrix, int x, int y, boolean[][] checked) {
        //System.out.println("\tcheck " + x + " " + y);
        if (x < 0 || matrix == null || matrix[0].length == 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1) {
            return Integer.MAX_VALUE;
        } else if (matrix[x][y] == 0) {
            return 0;
        } else if (!checked[x][y]) {
            checked[x][y] = true;
            return 1 +
                    Math.min(findClosestZero(matrix, x - 1, y, checked),
                            Math.min(findClosestZero(matrix, x + 1, y, checked),
                                    Math.min(findClosestZero(matrix, x, y - 1, checked),
                                            Math.min(findClosestZero(matrix, x, y + 1, checked), Integer.MAX_VALUE))));
        } else {
            //System.out.println("case: " + x + " " + y);
            return 2;
        }
    }

    public void print(int[][] matrix) {
        System.out.println("new matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
