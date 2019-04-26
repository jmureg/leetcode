package strings;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyAtoi {

    @Test
    public void test() {
        assertEquals(42, myAtoi("42"));
        assertEquals(-42, myAtoi("   -42"));
        assertEquals(0, myAtoi("words and 987"));
        assertEquals(-2147483648, myAtoi("-91283472332"));
        assertEquals(0, myAtoi("words and 987"));
        assertEquals(0, myAtoi("+"));
        assertEquals(0, myAtoi("-"));
        assertEquals(0, myAtoi("+-2"));
        assertEquals(-5, myAtoi("-5-"));
        assertEquals(1, myAtoi("+1"));
        assertEquals(Integer.MAX_VALUE, myAtoi("20000000000000000000"));
        assertEquals(12345678, myAtoi("  0000000000012345678"));
        assertEquals(-1, myAtoi("-000000000000001"));
        assertEquals(-2147483648, myAtoi("-2147483648"));
    }

    public int myAtoi(String str) {
        String clean = cleanup(str);
        int value = transform(clean);
        return value;
    }

    private int transform(String clean) {
        boolean pos = true; // per default
        if (!clean.equals("") && clean.length() > 0) {
            if (clean.charAt(0) == '-') {
                pos = false;
                clean = clean.substring(1);
                if (clean.equals("") || clean.charAt(0) == '-' || clean.charAt(0) == '+') {
                    return 0;
                }
            } else if (clean.charAt(0) == '+') {
                clean = clean.substring(1);
                if (clean.equals("") || clean.charAt(0) == '-' || clean.charAt(0) == '+') {
                    return 0;
                }
            }
            if (clean.length() == 1 && isSign(clean)) {
                return 0;
            }
        } else {
            return 0;
        }
        int val = 0;
        try {
            if (pos && clean.length() > 12) {
                return Integer.MAX_VALUE;
            } else if (!pos && clean.length() > 12) {
                return Integer.MIN_VALUE;
            }
            val = Integer.valueOf(clean);
        } catch (Exception ex) {
            long l = Long.valueOf(clean);
            if (pos && l >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (!pos && -l <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return pos ? val : -val;
    }

    private boolean isSign(String clean) {
        return clean.equals("+") || clean.equals("-");
    }

    private String cleanup(String str) {
        boolean signUsed = false;
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        if (str.length() > 0 && allowedSign(str.charAt(0))) {
            signUsed = true;
            sb.append(str.charAt(0));
            str = str.substring(1);
        }
        while (str.length() > 0 && str.charAt(0) == '0') {
            str = str.substring(1);
        }
        if (str != null && !str.equals("")) {
            for (int i = 0; i < str.length(); i++) {
                Character ch = str.charAt(i);
                if (allowedNumber(ch)) {
                    sb.append(ch);
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }

    private boolean allowedSign(Character ch) {
        return "+-".indexOf(ch) >= 0;
    }

    private boolean allowedNumber(Character ch) {
        return "0123456789".indexOf(ch) >= 0;
    }
}
