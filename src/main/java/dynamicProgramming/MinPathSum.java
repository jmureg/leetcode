package dynamicProgramming;

/*
https://leetcode.com/problems/minimum-path-sum/
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if( i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                dp[i][j] = grid[i][j] + Math.min(j > 0 ? dp[i][j-1] : Integer.MAX_VALUE, i > 0 ? dp[i-1][j] : Integer.MAX_VALUE);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        MinPathSum mps = new MinPathSum();

        int[][] grid = new int[][]{{1,3,1}};
        System.out.println(mps.minPathSum(grid));

        grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(mps.minPathSum(grid));

        grid = new int[][]{{1,3},{1,5}};
        System.out.println(mps.minPathSum(grid));

        grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(mps.minPathSum(grid));
    }
}
