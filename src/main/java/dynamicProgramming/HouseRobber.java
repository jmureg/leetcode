package dynamicProgramming;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums = null;

        nums = new int[]{2, 1, 1, 2};
        System.out.println("4: " + hr.rob(nums));

        nums = new int[]{1, 2, 2, 1};
        System.out.println("3: " + hr.rob(nums));

        nums = new int[]{1, 2, 1, 2, 1, 2};
        System.out.println("6: " + hr.rob(nums));

        nums = new int[]{1, 2, 3, 1};
        System.out.println("4: " + hr.rob(nums));

        nums = new int[]{};
        System.out.println("0: " + hr.rob(nums));

        nums = new int[]{2};
        System.out.println("2: " + hr.rob(nums));

        nums = new int[]{2, 7, 9, 3, 1};
        System.out.println("12: " + hr.rob(nums));
    }

    HouseRobber() {
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] db = new int[nums.length + 1];
        db[0] = 0;
        db[1] = nums[0];
        db[2] = Math.max(nums[1], nums[0]);
        for (int i = 3; i < db.length; i++) {
            db[i] = Math.max(nums[i - 1] + db[i - 2], db[i - 1]);
        }

        return db[nums.length];
    }

    public int robIntuitive(int[] nums) {
        int max = 0;

        for (int outer = 0; outer < nums.length; outer++) {
            int current = 0;
            int inner = 0;
            for (inner = outer; inner <= nums.length - 1; inner += 2) {
                current += nums[inner];
                if (current > max) {
                    max = current;
                }
            }
            if (inner + 2 == nums.length) {
                inner += 2;
                current += nums[inner];
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }
}
