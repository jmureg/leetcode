package sortNfind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindrom {

    @Test
    public void test() {
        /*
         */
        assertEquals("assa", longestPalindrome("assa"));
        assertEquals("bb", longestPalindrome("cbbd"));
        assertEquals("asdfghjjhgfdsa", longestPalindrome("asdfghjjhgfdsa"));
        assertEquals("ghjhg", longestPalindrome("asddghjhgfdsa"));
        assertEquals("aba", longestPalindrome("babad"));
        assertEquals("ccc", longestPalindrome("ccc"));

        assertEquals("bb", longestPalindrome("cbbd"));
    }

    String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
