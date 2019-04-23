package bitmanipulation;

import java.util.*;

public class CountTripletsBitwiseAnd {
    public static void main(String[] args) {
        System.out.println("12 " + countTriplets(new int[]{2,1,3}));
        System.out.println("0 " + countTriplets(new int[]{2,2,2}));
        System.out.println("-1 " + countTriplets(new int[]{2,1, (int)Math.pow(2, 17)}));
    }

    public static int countTripletsBruitForce(int[] A) {
        if(A==null || A.length>1000) {
            return -1;
        }
        for (int x: A
             ) {
            if(x>Math.pow(2, 16)) {
                return -1;
            }
        }
        int counter = 0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A.length; j++) {
                for(int k=0; k<A.length; k++) {
                    if((A[i] & A[j] & A[k]) == 0) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static int countTriplets(int[] A) {
        if(A==null || A.length>1000) {
            return -1;
        }
        for (int x: A
        ) {
            if(x>Math.pow(2, 16)) {
                return -1;
            }
        }
        int counter = 0;

        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A.length; j++) {
                if(cache.containsKey((A[i] & A[j]))) {
                    int entry = cache.get((A[i] & A[j]));
                    cache.put((A[i] & A[j]), ++entry);
                } else {
                    cache.put((A[i] & A[j]), 1);
                }
            }
        }

        for(int i=0; i<A.length; i++) {
            Set<Integer> keys = cache.keySet();
            for (int key: keys
                 ) {
                if((A[i] & key)==0) {
                    counter+=cache.get(key);
                }
            }
        }


        return counter;
    }
}
