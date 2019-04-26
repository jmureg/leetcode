package math;

import java.util.HashMap;

public class Fibonnaci {

    static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public static void main(String[] args) {

        System.out.println(fibonnaci(5));
        System.out.println(fibonnaciMemorization(5));
    }

    private static int fibonnaci(int n) {
        if (n < 0 || n == 1) {
            return 1;
        } else {
            return fibonnaci(n - 2) + fibonnaci(n - 1);
        }
    }

    private static int fibonnaciMemorization(int n) {
        if (cache.get(n) != null) {
            return cache.get(n);
        }

        int result = 0;
        if (n < 0 || n == 1) {
            return 1;
        } else {
            result = fibonnaciMemorization(n - 2) + fibonnaciMemorization(n - 1);
        }
        cache.put(n, result);

        return result;
    }
}
