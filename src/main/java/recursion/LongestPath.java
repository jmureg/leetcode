package recursion;

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

 2d array of 1s and 0s
 we want to find the longest contiguous path in the array of 1s
 0s = water
 1s = land
 find the biggest island!
 https://leetcode.com/problems/max-area-of-island/
 */
public class LongestPath {
    int[][] grid;

    /*
    source https://leetcode.com/problems/max-area-of-island/solution/
    */
    boolean[][] seen;

    public static void main(String[] args) {

        LongestPath lp = new LongestPath();

        int[][] ex0 = new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 1},
        };
        System.out.println("expected 3: " + lp.longestPath(ex0));


        int[][] ex1 = new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 1, 1},
                new int[]{0, 0, 1, 1},
                new int[]{0, 0, 1, 1},
                new int[]{0, 1, 0, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 0}
        };
        System.out.println("expected 6: " + lp.longestPath(ex1));


        int[][] ex2 = new int[][]{
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 1},
                new int[]{0, 0, 1, 1}
        };
        System.out.println("expected 5: " + lp.longestPath(ex2));

        int[][] ex3 = new int[][]{
                new int[]{1}
        };
        System.out.println("expected 1: " + lp.longestPath(ex3));


        int[][] ex4 = new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{1, 1, 1, 1},
                new int[]{0, 0, 1, 0},
                new int[]{1, 0, 0, 1},
                new int[]{1, 1, 1, 1},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 0}
        };
        System.out.println("expected 6: " + lp.longestPath(ex4));

        int[][] ex5 = new int[][]{
                new int[]{0}
        };
        System.out.println("expected 0: " + lp.longestPath(ex5));

        int[][] ex6 = new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        };
        System.out.println("expected 1: " + lp.longestPath(ex6));

        int[][] ex7 = new int[][]{
                new int[]{1, 1}
        };
        System.out.println("expected 1: " + lp.longestPath(ex6));
    }

    public int longestPath(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }

    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r + 1, c) + area(r - 1, c)
                + area(r, c - 1) + area(r, c + 1));
    }


    public int longestPath2(int[][] matrix) {
        int maxLength = 0;
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix.length == 1 && matrix[0].length == 1) {
            return (matrix[0][0] == 1) ? 1 : 0;
        }

        boolean[][] path = new boolean[matrix.length][matrix[0].length];

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                //System.out.println("current position: X:" + x + " and Y:" + y);
                int currentLength = checkPath(x, y, matrix, path);
                //System.out.println("\t current: " + currentLength);
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }

        return maxLength;
    }

    public int checkPath(int x, int y, int[][] matrix, boolean[][] path) {
        //System.out.println("\t check recursive position: X:" + x + " and Y:" + y);

        // y + 1
        if (y < matrix.length - 1 && matrix[y + 1][x] == 1 && path[y + 1][x] == false) {
            boolean[][] cloneD = path.clone();
            cloneD[y][x] = true;
            return 1 + checkPath(x, y + 1, matrix, cloneD);
        }

        // y - 1
        if (y > 0 && matrix[y - 1][x] == 1 && path[y - 1][x] == false) {
            boolean[][] cloneU = path.clone();
            cloneU[y][x] = true;
            return 1 + checkPath(x, y - 1, matrix, cloneU);
        }

        // x + 1
        if (x < matrix[0].length - 1 && matrix[y][x + 1] == 1 && path[y][x + 1] == false) {
            boolean[][] cloneR = path.clone();
            cloneR[y][x] = true;
            return 1 + checkPath(x + 1, y, matrix, cloneR);
        }

        // x - 1
        if (x > 0 && matrix[y][x - 1] == 1 && path[y][x - 1] == false) {
            boolean[][] cloneL = path.clone();
            cloneL[y][x] = true;
            return 1 + checkPath(x - 1, y, matrix, cloneL);
        }

        return 0;
    }
}