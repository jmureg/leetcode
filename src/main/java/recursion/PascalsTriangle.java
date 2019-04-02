package recursion;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PascalsTriangle {

    @Test
    public void test() {


        pascalsTriangleIndexRow(3);

/*

        pascalsTriangleList(5);
        pascalsTriangleList(0);
        pascalsTriangleList(1);


        assertEquals(3, pascalsTriangleRecursive(4, 2));
        assertEquals(3, pascalsTriangleRecursive(4, 3));
        assertEquals(6, pascalsTriangleRecursive(5, 3));


        assertEquals(6, pascalsTriangle(5));
*/
    }

    public List<List<Integer>> pascalsTriangleList(int numRows) {
        if(numRows<=0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> next = new ArrayList<Integer>();
        result.add(0, next);
        next.add(1);

        for(int o=1; o<numRows; o++) {
            next = new ArrayList<Integer>();
            result.add(o, next);
            next.add(1);
            for(int i=1; i<result.get(o-1).size(); i++) {
                next.add(result.get(o-1).get(i-1) + result.get(o-1).get(i));
            }
            next.add(1);
        }


        return result;
    }

    public List<Integer> pascalsTriangleIndexRow(int rowIndex) {
        if(rowIndex<=0) {
            List<Integer> next = new ArrayList<Integer>();
            next.add(1);
            return next;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> next = new ArrayList<Integer>();
        result.add(0, next);
        next.add(1);

        for(int o=1; o<rowIndex+1; o++) {
            next = new ArrayList<Integer>();
            result.add(o, next);
            next.add(1);
            for(int i=1; i<result.get(o-1).size(); i++) {
                next.add(result.get(o-1).get(i-1) + result.get(o-1).get(i));
            }
            next.add(1);
        }


        return result.get(result.size()-1);
    }

    public int pascalsTriangleRecursive(int row, int column) {
        if (row == column || column == 1) {
            return 1;
        }
        return pascalsTriangleRecursive(row - 1, column - 1) + pascalsTriangleRecursive(row - 1, column);

    }

    /*
        Highest number
     */
    public int pascalsTriangle(int n) {
        int number = 0;
        int[][] moves = new int[n + 1][n + 1];
        Arrays.fill(moves[0], 1);
        fillDiagonal(moves, 1);

        for (int row = 1; row < n; row++) {
            for (int column = 0; column < n; column++) {
                moves[row + 1][column + 1] = moves[row][column] + moves[row][column + 1];
                if (moves[row + 1][column + 1] > number) {
                    number = moves[row + 1][column + 1];
                }
            }
        }

        return number;
    }

    private void fillDiagonal(int[][] moves, int n) {
        for (int i = 0; i < moves.length; i++) {
            moves[i][i] = n;
        }
    }
}
