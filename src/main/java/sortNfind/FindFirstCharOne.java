package sortNfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindFirstCharOne {
    public static void main(String[] args) {

        char[] list = new char[]{'r', 'd', 'e', 'r', 'r', 't', 'e', 'f', 'n', 'f'};
        char c = findFirstCharOne(list);
        System.out.println("Found char: " + c);
    }

    private static char findFirstCharOne(char[] list) {
        ArrayList<Character> order = new ArrayList<Character>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char ch : list
        ) {
            System.out.println("Checking char: " + ch);

            if (order.contains(ch)) {
                int hit = map.get(ch);
                map.put(ch, ++hit);
            } else {
                map.put(ch, 1);
                order.add(ch);
            }
        }
        for (char o : order
        ) {
            if (map.get(o) == 1) {
                return o;
            }
        }
        return '.';
    }


}
