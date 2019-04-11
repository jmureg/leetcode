package sortNfind;

import java.util.HashMap;
import java.util.Map;

public class FirstBadVersion {
    public static int COUNTER = 0;
    public static void main(String[] args) {
        System.out.println("firstBadVersion: " + firstBadVersion(1000));
        //System.out.println("firstBadVersion: " + firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        Map<Integer, Boolean> cache = new HashMap<>();
        if(n<=1) {
            return n;
        } else {
            int lowPivot = 0;
            int currentPivot = n/2;
            int highPivot = n;

            while (!(isBadVersion(currentPivot) && !isBadVersion(currentPivot-1))) {
                boolean isBad = isBadVersion(currentPivot);
                cache.put(currentPivot, isBad);
                if(isBad) {
                    highPivot = currentPivot;
                    currentPivot = currentPivot - ((currentPivot-lowPivot)/2);
                } else {
                    lowPivot = currentPivot;
                    currentPivot = currentPivot + (highPivot-currentPivot)/2;
                }
            }
            return currentPivot;
        }
    }

    private static boolean isBadVersion(int pivot) {
        System.out.println("invocation: " + COUNTER++);
        if(pivot>=49) {
            return true;
        } else {
            return false;
        }
    }
}
