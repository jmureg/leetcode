package strings;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        reverseStringInPlace(new char[]{'h', 'e', 'l', 'l', 'o'});
        reverseStringRecursive(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    public static void reverseStringInPlace(char[] s) {
        if (s == null) {
            System.out.println();
        } else if (s.length == 1) {
            System.out.println(String.valueOf(s));
        } else {
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                swap(s, left++, right--);
            }
            System.out.println(String.valueOf(s));
        }
    }

    private static char[] reverseStringRecursive(char[] s) {
        if (s == null) {
            return null;
        } else if (s.length == 1) {
            System.out.print(s);
            return s;
        } else {
            System.out.print(s[s.length - 1]);
            return reverseStringRecursive(Arrays.copyOfRange(s, 0, s.length - 1));
        }

    }

    public static void swap(char[] s, int l, int r) {
        char t = s[l];
        s[l] = s[r];
        s[r] = t;
    }
}
