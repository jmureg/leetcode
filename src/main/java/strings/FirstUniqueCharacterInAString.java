package strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println("0: " + firstUniqChar("leetcode"));
        System.out.println("2: " + firstUniqChar("loveleetcode"));
        System.out.println("-1: " + firstUniqChar(""));
        System.out.println("-1: " + firstUniqChar(null));
        System.out.println("-1: " + firstUniqChar("ee"));
    }

    public static int firstUniqChar(String s) {
        if(s==null || s.length()<1) {
            return -1;
        }
        Map<Character, Integer> cache = generateCache(s);
        int pos = findFirstPosition(s, cache);
        return pos;
    }

    private static int findFirstPosition(String s, Map<Character, Integer> cache) {
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(cache.get(c)==1) {
                return i;
            }
        }
        return -1;
    }

    private static Map<Character, Integer> generateCache(String s) {
        Map<Character, Integer> cache = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            int value = 0;
            if(cache.containsKey(c)) {
                value = cache.get(c);
            }
            cache.put(c, ++value);
        }
        return cache;
    }
}
