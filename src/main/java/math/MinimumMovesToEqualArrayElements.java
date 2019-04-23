package math;

// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/submissions/
public class MinimumMovesToEqualArrayElements {

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElements mmteqe = new MinimumMovesToEqualArrayElements();
        int[] nums = new int[]{1,2,3};

        System.out.println("3: " + mmteqe.minMoves(nums));
    }

    public int minMoves(int[] nums) {
        int steps = 0;
        int min = Integer.MAX_VALUE;
        for (int n : nums)
            min = Math.min(n, min);
        for (int n : nums)
            steps += n - min;
        return steps;
    }
}
