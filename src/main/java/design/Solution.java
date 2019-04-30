package design;

import java.util.Arrays;
import java.util.Random;

class Solution {
    int[] nums = null;
    int[] shuffled = null;
    Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.shuffled = nums.clone();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution sol = new Solution(nums);
        System.out.println(Arrays.toString(sol.shuffle()));
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        this.shuffled = nums.clone();
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int counter = nums.length;

        while (counter > 0) {
            int nextElem = this.rand.nextInt(counter--);
            swap(this.shuffled, counter, nextElem);
        }
        return this.shuffled;
    }

    private void swap(int[] shuffled, int counter, int nextElem) {
        int tmp = shuffled[counter];
        shuffled[counter] = shuffled[nextElem];
        shuffled[nextElem] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */