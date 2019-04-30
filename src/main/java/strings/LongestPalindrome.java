package strings;

/*
source
https://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
 */
public class LongestPalindrome {

    LongestPalindrome(){
    }



    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String s = null;

        s = new String("abb");
        System.out.println("bb: " + lp.longestPalindrome(s));

        s = new String("ccc");
        System.out.println("ccc: " + lp.longestPalindrome(s));

        s = new String("");
        System.out.println(": " + lp.longestPalindrome(s));

        s = new String("juliussuiluj");
        System.out.println("a: " + lp.longestPalindrome(s));

        s = new String("a");
        System.out.println("a: " + lp.longestPalindrome(s));

        s = new String("babad");
        System.out.println("aba: " + lp.longestPalindrome(s));

        s = new String("cbbd");
        System.out.println("bb: " + lp.longestPalindrome(s));
    }
}
