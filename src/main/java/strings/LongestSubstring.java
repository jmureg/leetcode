package strings;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println("Max length abcabcbb 3: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Max length bbbbb 1: " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("Max length pwwkew 3: " + lengthOfLongestSubstring("pwwkew"));
        System.out.println("Max length aab 2: " + lengthOfLongestSubstring("aab"));
        System.out.println("Max length dvdf 3: " + lengthOfLongestSubstring("dvdf"));
        System.out.println("Max length dvdf 6: " + lengthOfLongestSubstring("ohvhjdml"));
    }

    public static int lengthOfLongestSubstring(String s) {
        List<Character> tmp = new ArrayList<Character>();
        int max = 0;

        for(Character ch: s.toCharArray()) {
            if(tmp.contains(ch) && tmp.size()==1) {

            } else if(tmp.indexOf(ch)==0) {
                tmp.remove(0);
                tmp.add(ch);
            } else if(tmp.indexOf(ch)>0) {
                for(int d = tmp.indexOf(ch); d>=0; d--) {
                    tmp.remove(d);
                    //System.out.println("remove pos" + d);
                }
                tmp.add(ch);
                //System.out.println("reset counter");
            } else {
                tmp.add(ch);
                if(tmp.size()>max) {
                    max = tmp.size();
                }
            }
        }
        return max;
    }
}
