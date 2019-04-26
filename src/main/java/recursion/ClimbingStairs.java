package recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String[] args) {
        Map<Integer, Integer> cache = new HashMap<>();
        System.out.println("climbStairs : " + climbStairs(6));
    }

    public static Map<Integer, Integer> cache = new HashMap<>();

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
}
