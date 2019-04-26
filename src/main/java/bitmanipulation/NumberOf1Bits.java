package bitmanipulation;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/565/

Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

 */
public class NumberOf1Bits {
    NumberOf1Bits() {
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        while (n != 0) {
            counter = counter + (n & 1);
            n = n >>> 1;
        }

        return counter;
    }

    public static void main(String[] args) {
        NumberOf1Bits no1b = new NumberOf1Bits();
        System.out.println("00000000000000000000000000001011: " + no1b.hammingWeight(00000000000000000000000000001011));
        System.out.println("00000000000000000000000010000000: " + no1b.hammingWeight(00000000000000000000000010000000));
        System.out.println("11111111111111111111111111111101: " + no1b.hammingWeight(-3));
    }
}
