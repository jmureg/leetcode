package recursion;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseString {
    @Test
    public void test() {
        assertEquals("ytrewq", reverseStringRecursive("qwerty"));
        assertEquals("suiluj", reverseStringRecursive("julius"));
    }

    private String reverseStringRecursive(String st) {
        if(st==null) {
            return "";
        } else if (st.length()==1) {
            return String.valueOf(st.charAt(0));
        } else {
            return st.charAt(st.length()-1) + reverseStringRecursive(st.substring(0, st.length()-1));
        }
    }


}
