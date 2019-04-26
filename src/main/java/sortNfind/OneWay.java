package sortNfind;

public class OneWay {
    public static void main(String[] args) {

        String a = "pale";
        String b = "apale";

        System.out.println(oneWay(a, b));
    }

    public static boolean oneWay(String a, String b) {
        boolean flag = false;
        int len = Math.abs(a.length() - b.length());

        if (!(len == 1 || len == 0)) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (len >= i && len >= j) {
            if ((a.charAt(i)) != (b.charAt(j))) {
                if ((a.charAt(i)) == (b.charAt(j + 1))) {            // insert
                    i++;
                    j = j + 2;
                } else if ((a.charAt(i)) == (b.charAt(j + 1))) {     // insert
                    i = i + 2;
                    j++;
                } else if ((a.charAt(i + 1)) == (b.charAt(j + 1))) {   // replace
                    i = i + 2;
                    j = j + 2;
                }
                if (flag) {
                    return false;
                } else
                    flag = true;
            }
        }

        return true;
    }
}
