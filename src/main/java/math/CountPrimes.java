package math;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/

Count the number of prime numbers less than a non-negative number, n.


 */
public class CountPrimes {
    CountPrimes() {
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }

    /* dynamic programming */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }

    /*
    simple
     */
    public int countPrimes2(int n) {
        int counter = 0;
        boolean noPrime = true;
        for (int i = 2; i < n; i++) {
            noPrime = true;
            for (int j = 2; j < i && noPrime; j++) {
                if (i % j == 0) {
                    noPrime = false;
                    continue;
                }
            }
            if (noPrime) {
                counter++;
            }
        }

        return counter;
    }
}
