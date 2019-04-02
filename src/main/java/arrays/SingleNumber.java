package arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = null;

        nums = new int[]{2, 2, 1};
        System.out.println("1 = " + singleNumber(nums));

        nums = new int[]{4,1,2,1,2};
        System.out.println("4 = " + singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

        for (int i:nums
        ) {
            if(!cache.containsKey(i)) {
                cache.put(i, 1);
            } else {
                cache.remove(i);
            }
        }

        Iterator it = cache.entrySet().iterator();
        Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();

        return entry.getKey();
    }
}
