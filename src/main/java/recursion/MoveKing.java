package recursion;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveKing {

    @Test
    public void test() {
        assertEquals(10, knightDialer(1));
        assertEquals(20, knightDialer(2));
        assertEquals(46, knightDialer(3));
    }

    public int knightDialer(int N) {
        int MOD = 1000000007;
        int[][] moves = new int[][]{
                {4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0},
                {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

        int[][] dp = new int[2][10];
        Arrays.fill(dp[0], 1);
        for (int hops = 0; hops < N - 1; ++hops) {
            Arrays.fill(dp[hops], 0);
            for (int node = 0; node < 10; ++node)
                for (int nei : moves[node]) {
                    dp[hops][nei] += dp[hops][node] + 1;
                    dp[hops][nei] %= MOD;
                }
        }

        long ans = 0;
        for (int x : dp[0])
            ans += x;
        return (int) (ans % MOD);
    }

    public int knightDialer2(int N) {
        int MOD = 1000000007;
        int[][] moves = new int[][]{
                {4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0},
                {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

        int[][] dp = new int[2][10];
        Arrays.fill(dp[0], 1);
        for (int hops = 0; hops < N - 1; ++hops) {
            Arrays.fill(dp[~hops & 1], 0);
            for (int node = 0; node < 10; ++node)
                for (int nei : moves[node]) {
                    dp[~hops & 1][nei] += dp[hops & 1][node];
                    dp[~hops & 1][nei] %= MOD;
                }
        }

        long ans = 0;
        for (int x : dp[~N & 1])
            ans += x;
        return (int) (ans % MOD);
    }
}
