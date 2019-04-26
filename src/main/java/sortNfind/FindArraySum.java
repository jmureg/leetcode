package sortNfind;

public class FindArraySum {

    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 5, 6};
        array = new int[]{1, 2, 4, 4};
        //array = new int[]{1, 2, 3, 4};
        int sum = 8;

        twoSumN2(array, sum);
        twoSumN(array, sum);

    }

    public static void twoSumN2(int[] nums, int sum) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == sum) {
                    System.out.println("i: " + i + " and j: " + j + " equals " + sum);
                }
            }
        }
    }


    public static void twoSumN(int[] nums, int sum) {
        int r = nums.length - 1;
        int l = 0;
        while (l < r && nums[l] + nums[r] <= sum) {
            if (nums[l] + nums[r] == sum) {
                System.out.println("Found a match at the positions " + l + " and " + r + " for the sum " + sum);
                return;
            } else if (l + 1 < r && nums[l + 1] + nums[r] <= sum) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("did not find a match!.");
    }
}
