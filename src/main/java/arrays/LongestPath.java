package arrays;

// 2d array of 1s and 0s
// we want to find the longest contiguous path in the array of 1s
// 0s = water
// 1s = land
// find the biggest island!


public class LongestPath {
    public static void main(String args[] ) throws Exception {

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
    }

    public int longestPath(int[][] matrix) {
        int maxLength = 0;
        if(matrix==null || matrix.length==0) {
            return 0;
        }
        if(matrix.length==1 && matrix[0].length==1) {
            return 1;
        }

        boolean[][] path = new boolean[matrix.length][matrix[0].length];

        for(int y=0; y<matrix.length; y++) {
            for(int x=0; x<matrix[0].length; x++) {
                //System.out.println("current position: X:" + x + " and Y:" + y);
                int currentLength = checkPath(x, y, matrix, path);
                //System.out.println("\t current: " + currentLength);
                if(currentLength>maxLength) {
                    maxLength = currentLength;
                }
            }
        }

        return maxLength;
    }

    public int checkPath(int x, int y, int[][] matrix, boolean[][] path) {
        //System.out.println("\t check recursive position: X:" + x + " and Y:" + y);

        // y + 1
        if(y<matrix.length-1 && matrix[y+1][x]==1 && path[y+1][x]==false) {
            boolean[][] cloneD = path.clone();
            cloneD[y][x] = true;
            return 1 + checkPath(x, y+1, matrix, cloneD);
        }

        // y - 1
        if(y>0 && matrix[y-1][x]==1 && path[y-1][x]==false) {
            boolean[][] cloneU = path.clone();
            cloneU[y][x] = true;
            return 1 + checkPath(x, y-1, matrix, cloneU);
        }

        // x + 1
        if(x<matrix[0].length-1 && matrix[y][x+1]==1 && path[y][x+1]==false) {
            boolean[][] cloneR = path.clone();
            cloneR[y][x] = true;
            return 1 + checkPath(x+1, y, matrix, cloneR);
        }

        // x - 1
        if(x>0 && matrix[y][x-1]==1 && path[y][x-1]==false) {
            boolean[][] cloneL = path.clone();
            cloneL[y][x] = true;
            return 1 + checkPath(x-1, y, matrix, cloneL);
        }

        return 0;
    }
}