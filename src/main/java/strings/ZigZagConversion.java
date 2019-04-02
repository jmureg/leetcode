package strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigZagConversion {
    public static void main(String[] args) {
        assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));
        assertEquals("AB", convert("AB", 1));
    }
    public static String convert(String s, int numRows) {
        boolean down = true;
        int counter = 0;
        if(numRows==1) {
            return s;
        }
        StringBuffer[] sba = new StringBuffer[numRows];
        for(int i=0; i<sba.length; i++) {
            sba[i] = new StringBuffer();
        }

        for(int i=0; i<s.length(); i++) {
            if(down && counter<numRows) {
                //System.out.println("down and append to " + counter);
                sba[counter].append(s.charAt(i));
                //System.out.println("increment counter");
                counter++;
            }
            if(!down && counter>0) {
                //System.out.println("up and append to " + counter);
                //fillAllBlankExceptI(i, numRows, sba);
                sba[counter].append(s.charAt(i));
                //System.out.println("increment counter");
                counter--;
            }
            if(counter==numRows) {
                down = false;
                counter = counter-2;
                //System.out.println("change direction to DOWN");
            }
            if(counter==0) {
                down = true;
                //System.out.println("change direction to UP");
            }
        }
        return buildResultString(sba);
    }

    private static String buildResultString(StringBuffer[] sba) {
        StringBuffer result = new StringBuffer();
        for(int i=0; i<sba.length; i++) {
            result.append(sba[i].toString());
        }
        return result.toString();
    }

    private static void fillAllBlankExceptI(int counter, int num, StringBuffer[] sb) {
        for(int x=0; x<num; x++) {
            if(x!=counter) {
                //sb[x].append(" ");
            } else {
                sb[x].append(x);
            }
        }
    }
}
