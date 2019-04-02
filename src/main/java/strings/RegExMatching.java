package strings;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class RegExMatching {

    @Test
    public void test() {
/*
 */
        assertEquals(true, isMatch("ab", ".*"));

        assertEquals(true, isMatch("aab", "c*a*b"));
        assertEquals(true, isMatch("aa", "a*"));
        assertEquals(false, isMatch("aa", "a"));
        assertEquals(true, isMatch("aa", "*"));
        assertEquals(true, isMatch("caab", "c*a*b"));
        assertEquals(false, isMatch("mississippi", "mis*is*p*."));
    }
    public boolean isMatch(String s, String p) {
        System.out.println("Check s&p match: " + s + " and " + p);

        if(p.isEmpty()) {
            return s.isEmpty();
        }
        boolean foundMatch = (!s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'));

        if(p.length()>=2 && p.charAt(1)=='*') {
            return (isMatch(s, p.substring(2)) || (foundMatch && isMatch(s.substring(1), p)));
        } else if(p.length()==1 && p.charAt(0)=='*') {
            return true;
        } else if(s.length()>1 && p.charAt(0)=='*') {
            Character c = s.charAt(0);
            while(s.length()>1 && s.charAt(1)==c) {
                s = s.substring(1);
            }
            return isMatch(s, p);
        }
        else {
            return foundMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

}
