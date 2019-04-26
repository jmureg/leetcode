package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        List<Integer> cache = new ArrayList<>();
        for (String time: timePoints
             ) {
            int hour = Integer.parseInt(time.substring(0,2));
            cache.add(hour * 60 + Integer.parseInt(time.substring(3,5)));
        }

        Collections.sort(cache, (Integer a, Integer b) -> a - b);

        for(int i=1; i<cache.size(); i++) {
            min = Math.min(min, cache.get(i)-cache.get(i-1));
        }

        int corner = cache.get(0) + (1440 - cache.get(cache.size()-1));
        return Math.min(min, corner);
    }

    public static void main(String[] args) {
        MinimumTimeDifference mtd = new MinimumTimeDifference();
        List<String> timePoints = null;

        timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println("1: " + mtd.findMinDifference(timePoints));

    }
}
