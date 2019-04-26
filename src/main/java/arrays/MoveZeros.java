package arrays;

public class MoveZeros {
    public static void main(String[] args) {

        int[] digits = null;

        digits = new int[]{0, 0, 0, 0, 0, 1};
        moveZeroes(digits);
        System.out.println("[1,0,0,0,0]");

        digits = new int[]{0, 1, 0, 3, 12};
        moveZeroes(digits);
        System.out.println("[1,3,12,0,0]");
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int next = findNoneNull(nums, i + 1);
                if (next != -1) {
                    swap(nums, i, next);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int next) {
        int temp = nums[i];
        nums[i] = nums[next];
        nums[next] = temp;
    }

    private static int findNoneNull(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    public static void moveZeroes2(int[] nums) {
        int[] result = new int[nums.length];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[counter++] = nums[i];
            }
        }

        nums = result;
    }
}
