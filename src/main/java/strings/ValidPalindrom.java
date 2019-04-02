package strings;

public class ValidPalindrom {
    public static void main(String[] args) {
        System.out.println("true: " + validPalindrom("`l;`` 1o1 ??;l`"));
        System.out.println("true: " + validPalindrom("Marge, let's \"went.\" I await news telegram."));
        System.out.println("true: " + validPalindrom("race a car"));
        System.out.println("true: " + validPalindrom("A man, a plan, a canal: Panama"));
        System.out.println("true: " + validPalindrom("abba"));
        System.out.println("true: " + validPalindrom("abcba"));
        System.out.println("true: " + validPalindrom(""));
        System.out.println("true: " + validPalindrom("abcde"));
    }

    private static boolean validPalindrom(String s) {
        String clean = cleanString(s);
        return checkValidPalindrom(clean);
    }

    private static String cleanString(String s) {
        s = s.replace(",", "");
        s = s.replace(":", "");
        s = s.replace(".", "");
        s = s.replace(";", "");
        s = s.replace("@", "");
        s = s.replace("#", "");
        s = s.replace("?", "");
        s = s.replace("!", "");
        s = s.replace("\"", "");
        s = s.replace("\\", "");
        s = s.replace("-", "");
        s = s.replace(" ", "");
        s = s.replace("'", "");
        s = s.replace("(", "");
        s = s.replace(")", "");
        s = s.replace("`", "");
        s = s.replace("|", "");
        s = s.replaceAll("[^\\x00-\\x7F]", "");
        s = s.trim();
        s = s.toLowerCase();

        return s;
    }

    private static boolean checkValidPalindrom(String clean) {
        if(clean==null || clean.length()==0) {
            return true;
        } else {
            for(int i=0; i<clean.length(); i++) {
                if(clean.charAt(i)!=clean.charAt(clean.length()-i-1)) {
                    return false;
                }
            }
            return true;
        }

    }
}
