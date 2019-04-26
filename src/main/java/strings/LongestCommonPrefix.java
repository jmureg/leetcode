package strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("a:" + longestCommonPrefix(new String[]{"a"}));
        System.out.println("fl:" + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(":" + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

        System.out.println("Juli:" + longestCommonPrefix(new String[]{"Julius", "Juli", "Julia"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        StringBuffer sb = new StringBuffer();
        int counter = 0;
        int min_len = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            if (min_len > strs[i].length()) {
                min_len = strs[i].length();
            }
        }


        for (int j = 0; j < min_len; j++) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(j) != strs[i + 1].charAt(j)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(counter++));
        }

        return sb.toString();
    }
}
