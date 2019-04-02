package recursion;

public class FindNSums {
    public static void main(String[] args) {
        int[] values = new int[]{5,-2,4,6,1,-3};
        permutation(values, 0, values.length-1);

    }

    public static int permutation(int[] input, int l, int r){
        printArray(input, l, r);
        int sum = 0;
        if(r-l<=0 || l>r) {
            return sum;
        } else if(r-l==1) {
            return input[l];
        } else {
            for (int i=l; i<r; i++) {
                sum = permutation(input, l, i) + permutation(input, i+1, r);
            }
        }
        //System.out.println("return sum: " + sum);
        return sum;
    }

    public static void printArray(int[] values, int l, int r) {
        System.out.println();
        for(int i=l; i<r; i++) {
            System.out.print(values[i] + " ");
        }
    }
}
