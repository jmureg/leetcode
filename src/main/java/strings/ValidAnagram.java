package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println("true: " + isAnagram("anagram", "nagaram"));
        System.out.println("false: " + isAnagram("rat", "car"));
        System.out.println("false: " + isAnagram("test", null));
    }

    public static boolean isAnagram(String s, String t) {
        List<Character> al = new ArrayList<Character>();
        for (char c: s.toCharArray()
             ) {
            al.add(c);
        }
        List<Character> tl = new ArrayList<Character>();
        for (char c: t.toCharArray()
        ) {
            tl.add(c);
        }

        if(s==null || t==null || s.length()!=t.length()) {
            return false;
        } else {
            for(int i=0; i<al.size(); i++) {
                Character current = al.get(i);
                tl.remove(current);
            }
            return tl.size()==0?true:false;
        }
    }
}
