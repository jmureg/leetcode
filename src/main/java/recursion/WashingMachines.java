package recursion;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WashingMachines {

    @Test
    public void test() {
        assertEquals(3, findMinMoves(new int[]{1, 0, 5}));
        assertEquals(2, findMinMoves(new int[]{0, 3, 0}));
        assertEquals(-1, findMinMoves(new int[]{1, 2}));
    }

    public int findMinMoves(int[] machines) {
        int moves = 0;
        if (machines == null) {
            return -1;
        }
        int n = findN(machines);
        if (n <= 0) {
            return -1;
        }
        int max = findMax(machines);
        if (max % machines.length != 0) {
            return -1;
        }
        while (!notBalanced(machines, n)) {
            moves += equalize(machines, n);
        }

        return moves;
    }

    private int equalize(int[] machines, int n) {
        int min = findMin(machines, n);
        int max = findMax(machines, n);

        if (min < max) {
            for (int i = max; i > min; i--) {
                machines[i]--;
                machines[i - 1]++;
            }
        }
        if (min > max) {
            for (int i = max; i < min; i++) {
                machines[i]--;
                machines[i + 1]++;
            }
        }

        return 1;
    }

    private int findMin(int[] machines, int n) {
        for (int i = 0; i < machines.length; i++) {
            if (machines[i] < n) {
                return i;
            }
        }
        return -1;
    }

    private int findMax(int[] machines, int n) {
        for (int i = 0; i < machines.length; i++) {
            if (machines[i] > n) {
                return i;
            }
        }
        return -1;
    }

    private boolean notBalanced(int[] machines, int n) {
        for (int num : machines
        ) {
            if (num != n) {
                return false;
            }
        }
        return true;
    }

    private int findN(int[] machines) {
        int x = 0;
        for (int i = 0; i < machines.length; i++) {
            x += machines[i];
        }
        return x / machines.length;
    }

    private int findMax(int[] machines) {
        int x = 0;
        for (int i = 0; i < machines.length; i++) {
            x += machines[i];
        }
        return x;
    }
}
