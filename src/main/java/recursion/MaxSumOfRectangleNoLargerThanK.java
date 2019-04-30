package recursion;

import arrays.MaximumSumCircularSubarray;

import java.util.TreeSet;

/*
https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

 */
public class MaxSumOfRectangleNoLargerThanK {
    MaxSumOfRectangleNoLargerThanK() {
    }

    /*
    source
    https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83618/2-Accepted-Java-Solution
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] areas = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int area = matrix[r][c];
                if (r-1 >= 0)
                    area += areas[r-1][c];
                if (c-1 >= 0)
                    area += areas[r][c-1];
                if (r-1 >= 0 && c-1 >= 0)
                    area -= areas[r-1][c-1];
                areas[r][c] = area;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int r2 = r1; r2 < rows; r2++) {
                TreeSet<Integer> tree = new TreeSet<>();
                tree.add(0);    // padding
                for (int c = 0; c < cols; c++) {
                    int area = areas[r2][c];
                    if (r1-1 >= 0)
                        area -= areas[r1-1][c];
                    Integer ceiling = tree.ceiling(area - k);
                    if (ceiling != null)
                        max = Math.max(max, area - ceiling);
                    tree.add(area);
                }
            }
        }
        return max;
    }

    int[][] matrix = null;
    int k = 0;
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        this.matrix = matrix;
        this.k = k;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int r=0; r<=matrix.length-1; r++) {
            for(int c=0; c<=matrix[0].length-1; c++) {
                int current = matrix[r][c];
                //System.out.println("checking c:" + c + " and r:" + r + " with value: " + current);
                if(current==k) {
                    return current;
                } else {
                    //int t = check(c, r, matrix[0].length-1, r);
                    ans = Math.max(check(c, r, c, r), (Math.max(check(c, r, matrix[0].length-1, r), (Math.max(check(c, r, c, matrix.length-1), check(c, r, matrix[0].length-1, matrix.length-1))))));
                    if(ans>max) {
                        max = ans;
                    }
               }
            }
        }
        return max;
    }

    private int check(int cs, int rs, int ce, int re) {
        int total = 0;
        int current = 0;
        for (int rr = rs; rr <= re; rr++) {
            for(int cc=cs; cc <= ce; cc++) {
                current = matrix[rr][cc];
                total += current;
                //System.out.println("\tchecking c:" + cc + " and r:" + rr + " with value: " + current);
            }
            if (total == this.k) {
                return total;
            }
        }

        return total>k?Integer.MIN_VALUE:total;
    }

    public static void main(String[] args) {
        MaxSumOfRectangleNoLargerThanK msr = new MaxSumOfRectangleNoLargerThanK();
        int[][] matrix = null;
        int k = 0;

        matrix = new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        k = 8;
        System.out.println("8: " + msr.maxSumSubmatrix(matrix, k));

        matrix = new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        k = 3;
        System.out.println("2: " + msr.maxSumSubmatrix(matrix, k));

        matrix = new int[][]{{2, 2, -1}};
        k = 0;
        System.out.println("-1: " + msr.maxSumSubmatrix(matrix, k));

        matrix = new int[][]{{1}};
        k = 2;
        System.out.println("1: " + msr.maxSumSubmatrix(matrix, k));

        matrix = new int[][]{{1}};
        k = 1;
        System.out.println("1: " + msr.maxSumSubmatrix(matrix, k));

        matrix = new int[][]{{1, 0, 1, 5},{0, -2, 3, -4},{0, 1, 1, 1}};
        k = 7;
        System.out.println("7: " + msr.maxSumSubmatrix(matrix, k));

        matrix = new int[][]{{1, 0, 1, 5},{0, -2, 3, -4}};
        k = 6;
        System.out.println("6: " + msr.maxSumSubmatrix(matrix, k));

        matrix = new int[][]{{1, 0, 1},{0, -2, 3}};
        k = 2;
        System.out.println("2: " + msr.maxSumSubmatrix(matrix, k));

        matrix = new int[][]{{1}};
        k = 0;
        System.out.println("0: " + msr.maxSumSubmatrix(matrix, k));
    }
}
