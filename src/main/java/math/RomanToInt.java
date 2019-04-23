package math;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/878/

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.


 */
public class RomanToInt {
    RomanToInt() {
    }

    public int romanToInt(String s) {
        int number = 0;
        int cut = 1;
        while (s.length() > 0) {
            cut = 1;
            Character character = s.charAt(0);
            switch (character) {
                case 'I':
                    if (s.length() > 1) {
                        if (s.charAt(1) == 'V') {
                            number += 4;
                            cut++;
                            break;
                        }
                        if (s.charAt(1) == 'X') {
                            number += 9;
                            cut++;
                            break;
                        }
                    }
                    number += 1;
                    break;
                case 'X':
                    if (s.length() > 1) {
                        if (s.charAt(1) == 'L') {
                            number += 40;
                            cut++;
                            break;
                        }
                        if (s.charAt(1) == 'C') {
                            number += 90;
                            cut++;
                            break;
                        }
                    }
                    number += 10;
                    break;
                case 'C':
                    if (s.length() > 1) {
                        if (s.charAt(1) == 'D') {
                            number += 400;
                            cut++;
                            break;
                        }
                        if (s.charAt(1) == 'M') {
                            number += 900;
                            cut++;
                            break;
                        }
                    }
                    number += 100;
                    break;
                case 'V':
                    number += 5;
                    break;
                case 'L':
                    number += 50;
                    break;
                case 'D':
                    number += 500;
                    break;
                case 'M':
                    number += 1000;
                    break;
                default: {

                }
            }
            s = reduceBy(s, cut);
        }

        return number;
    }

    private String reduceBy(String s, int i) {
        return s.substring(i, s.length());
    }

    public static void main(String[] args) {
        RomanToInt rti = new RomanToInt();
        System.out.println("621: " + rti.romanToInt("DCXXI"));
        System.out.println("1994: " + rti.romanToInt("MCMXCIV"));
        System.out.println("3: " + rti.romanToInt("III"));
        System.out.println("4: " + rti.romanToInt("IV"));
        System.out.println("9: " + rti.romanToInt("IX"));
        System.out.println("58: " + rti.romanToInt("LVIII"));
    }
}