package com.hs.easy;

public class SortArrayByParity2 {
	public int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;

        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }

            while (j < n && nums[j] % 2 == 1) {
                j += 2;
            }

            if (i < n && j < n) {
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}