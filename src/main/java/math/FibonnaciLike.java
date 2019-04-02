package math;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonnaciLike {

    @Test
    public void test() {
/*
 */
        assertEquals(5, lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));

        assertEquals(3, lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
        assertEquals(5, lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
        assertEquals(0, lenLongestFibSubseq(new int[]{1,3,5}));

    }

    public int lenLongestFibSubseq(int[] A) {
        int counter = 0;
        int max = 0;
        List<Integer> rl = new ArrayList<Integer>();
        if(A==null || A.length<3){
            return 0;
        }
        for(int i=A.length; i>0; i--) {
            int high=i-1;
            for(int j=high-1; j>=0; j--) {
                high=i-1;
                int low=j;

                int x = -1;
                while(Math.min(high,low)>=0 && !checkedBefore(rl, A[high], A[low]) && existsBefore(A, A[high]-A[low], low)>-1) {
                    if(rl.indexOf(A[high])==-1){
                        rl.add(0, A[high]);
                    }
                    if(rl.indexOf(A[low])==-1){
                        rl.add(0, A[low]);
                    }
                    x = existsBefore(A, A[high]-A[low], low);
                    high=low;
                    low=x;
                }
                if(x>-1) {
                    rl.add(0, A[low]);
                }
                if(rl.size()>max) {
                    max = rl.size();
                    System.out.println("Found new max: " + max + rl.toString());
                }
                rl.clear();
            }
        }
        return max;
    }

    private boolean checkedBefore(List<Integer> a, int i, int j) {
        if (a.lastIndexOf(i)>-1 && a.indexOf(j)>-1) {
            return true;
        } else {
            return false;
        }
    }

    private int existsBefore(int[] a, int n, int end) {
        for(int i=0; i<end; i++) {
            if(a[i]==n) {
                return i;
            }
        }
        return -1;
    }
}
