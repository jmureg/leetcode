package recursion;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/climbing-stairs/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Map<Integer, Integer> cache = new HashMap<>();

        int stairs = 10;
        System.out.println("climbStairs : " + climbStairs(stairs));
        System.out.println("climbStairs : " + climbStairsRecursion(stairs));
    }

    public static int climbStairs(int n) {
        cache.put(1, 1);

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 3;
        } else {
            int one = -1;
            int two = -1;

            if (cache.get(n - 1) == null) {
                one = climbStairs(n - 1);
                cache.put(n - 1, one);
            } else {
                one = cache.get(n - 1);
            }
            if (cache.get(n - 2) == null) {
                two = climbStairs(n - 2);
                cache.put(n - 2, two);
            } else {
                two = cache.get(n - 2);
            }

            return one + two;
        }
    }

    public static int climbStairsRecursion(int n) {
        if (n <1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 3;
        } else {
            return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
        }
    }
}