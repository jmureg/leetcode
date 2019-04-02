package arrays;

public class RotateArray {
    public static void main(String[] args) {
        System.out.println("[1,2,3,4,5,6,7] and k=3");
        int[] array = null;
/*
        array = new int[]{1,2,3,4,5,6,7};
        rotate(array, 3);

        array = new int[]{-1,-100,3,99};
        rotate(array, 2);

        array = new int[]{};
        rotate(array, 2);

        array = null;
        rotate(array, 2);
*/
        array = new int[]{1,2};
        rotate(array, 3);

        System.out.println("fin.");
    }
    public static void rotate(int[] nums, int k) {
        if(k<0 || nums==null) {
            return;
        }
        if(k>nums.length) {
            k = k % nums.length;
        }
        int[] tmp = new int[k];
        int n=k;
        for(int i=nums.length-1; i>nums.length-k-1; i--) {
            tmp[--n] = nums[i];
        }
        for(int i=nums.length-k-1; i>=0; i--) {
            nums[i+k] = nums[i];
        }
        for(int i=k-1; i>=0; i--) {
            nums[i] = tmp[i];
        }
    }
}
