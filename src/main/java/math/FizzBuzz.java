package math;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/743/

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

 */
public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        System.out.println(fb.fizzBuzz(15).toString());
    }

    FizzBuzz() {
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean three = i % 3 == 0;
            boolean five = i % 5 == 0;
            if (three && five) {
                result.add("FizzBuzz");
            } else if (three) {
                result.add("Fizz");
            } else if (five) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
