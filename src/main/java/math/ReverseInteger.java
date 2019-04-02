package math;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseInteger {
    public static void main(String[] args) {
/*
        assertEquals(321, reverse(123));
        assertEquals(-321, reverse(-123));
        assertEquals(21, reverse(120));
        assertEquals(0, reverse(1534236469));

* */
        assertEquals(-2147483641, reverse(-1463847412));
    }
    public static int reverse(int x) {
        int result = 0;
        while(x!=0) {
            int tmp = x%10;
            x = x/10;
            if(Integer.MIN_VALUE/10>result || (result == Integer.MIN_VALUE / 10 && tmp < -8)) {
                return 0;
            }
            if(Integer.MAX_VALUE/10<result || (result == Integer.MAX_VALUE / 10 && tmp > 7)) {
                return 0;
            }
            result = result * 10 + tmp;
        }
        return result;
    }
}
