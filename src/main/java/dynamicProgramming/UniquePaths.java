package dynamicProgramming;

import java.util.Arrays;

/*
https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int x=0;x<dp.length;x++)
            Arrays.fill( dp[x], 1);

        for (int row=1; row<m; row++) {
            for(int column=1; column<n; column++) {
                dp[row][column] = dp[row-1][column] + dp[row][column-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println("expect 3:" + up.uniquePaths(3, 2));

        up = new UniquePaths();
        System.out.println("expect 28:" + up.uniquePaths(3, 7));

    }
}
