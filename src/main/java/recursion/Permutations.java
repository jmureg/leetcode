package recursion;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/permutations/

Given a collection of distinct integers, return all possible permutations.

 */
public class Permutations {
    Permutations() {
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = null;

        nums = new int[]{1, 2};
        System.out.println(">" + p.permute(nums));

        nums = new int[]{1, 2, 3};
        System.out.println(">" + p.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        perm(0, nums, result);
        return result;
    }

    private void perm(int left, int[] nums, List<List<Integer>> result) {
        if (left == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        for (int i = left; i < nums.length; i++) {
            swap(nums, i, left);
            perm(left + 1, nums, result);
            swap(nums, i, left);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void printArray(int[] input) {
        System.out.print('\n');
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
        System.out.println();
    }

    private void printArray(List<Integer> input) {
        System.out.print('\n');
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i));
        }
        System.out.println();
    }
}