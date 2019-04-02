package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {

        int[] digits = null;
        int[] result = null;

        digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        result = plusOne(digits);
        System.out.println("[9,8,7,6,5,4,3,2,1,1] = " + Arrays.toString(result));

        digits = new int[]{9};
        result = plusOne(digits);
        System.out.println("[1,0] = " + Arrays.toString(result));

        digits = new int[]{1,2,3};
        result = plusOne(digits);
        System.out.println("[1,2,4] = " + Arrays.toString(result));

        digits = new int[]{4,3,2,1};
        result = plusOne(digits);
        System.out.println("[4,3,2,2] = " + Arrays.toString(result));

        digits = new int[]{0};
        result = plusOne(digits);
        System.out.println("[1] = " + Arrays.toString(result));

        digits = new int[]{9,9,9,9,9};
        result = plusOne(digits);
        System.out.println("[1,0,0,0,0] = " + Arrays.toString(result));

        digits = new int[]{9,0,0,8,8,4,9,6,8,2,1,1,3,9,4,9,5,1,1,2,5,4,9,1,2,0,8,1,4,1,9,6,3,9,6,1,5,7};
        result = plusOne(digits);
        System.out.println("[..] = " + Arrays.toString(result));

    }

    public static int[] plusOne(int[] digits) {
        List<Integer> current = new ArrayList<>();
        boolean carryOver = false;
        for(int i=digits.length-1; i>=0; i--) {
            int num = digits[i];
            if(num==9 && carryOver) {
                num = 0;
            } else if(num<9 && carryOver){
                num++;
                carryOver=false;
            } else if(i==digits.length-1){
                num++;
                if(num>9) {
                    carryOver=true;
                    num = 0;
                }
            }
            current.add(0, (Integer)num);
        }
        if(carryOver) {
            current.add(0, (Integer)1);
        }

        int[] result = new int[current.size()];
        for(int i=0; i<current.size(); i++) {
            result[i] = current.get(i);
        }

        return result;
    }

    public static int[] plusOne2(int[] digits) {
        int factor = 1;
        long num = 0;

        for(int i=digits.length-1; i>=0; i--) {
            num += digits[i] * factor;
            factor = factor * 10;
        }

        num = num+1;

        int length = (int) (Math.log10(num) + 1);
        int[] result = new int[length];
        int counter = length-1;
        while (num>9) {
            long rest = num % 10;
            result[counter--] = (int)rest;
            num = num/10;
        }
        result[counter] = (int)num;

        return result;
    }
}
