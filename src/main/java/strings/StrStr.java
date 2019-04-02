package strings;

public class StrStr {
    public static void main(String[] args) {
        System.out.println("-1: " + strStr("", "asas"));
        System.out.println("2: " + strStr("hello", "ll"));
        System.out.println("0: " + strStr("aaa", "a"));
        System.out.println("4: " + strStr("mississippi", "issip"));
        System.out.println("-1: " + strStr("mississippi", "issipi"));
        System.out.println("10: " + strStr("qwertyuiopyuiol", "yuiol"));
        System.out.println("-1: " + strStr("qwertyuio", "qwertyuiop"));

        System.out.println("0: " + strStr("hello", ""));

        System.out.println("-1: " + strStr("aaaaa", "bba"));

    }

    public static int strStr(String haystack, String needle) {
        if(needle==null || needle.equals("")) {
            return 0;
        } else if ((haystack==null || haystack.equals("") && needle.length()>0) || (haystack.length()<needle.length())) {
            return -1;
        } else {
            int h;
            for(int i=0; i<haystack.length(); i++) {
                h=i;
                for(int n=0; n<needle.length() && h<haystack.length(); n++) {
                    Character hc = haystack.charAt(h);
                    Character nc = needle.charAt(n);
                    if(haystack.charAt(h)!=needle.charAt(n)) {
//                        h=i;
                        break;
                    } else if(n==needle.length()-1) {
                        return i;
                    }
                    if(n<=needle.length()) {
                        h++;
                    } else {
                        h=0;
                        break;
                    }
                }
            }
            return -1;
        }
    }
}
