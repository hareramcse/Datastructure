package com.hs.leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
		int firstIndex = countOccurance(nums, target, true);
		int lastIndex = countOccurance(nums, target, false);
		int[] res = new int[2];
		res[0] = firstIndex;
		res[1] = lastIndex;
		return res;
	}

	private int countOccurance(int[] nums, int target, boolean searchFirst) {
		int length = nums.length;
		int low = 0, high = length - 1, result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				result = mid;
				if (searchFirst) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
		// array should be strictly sorted
		int arr[] = { 12, 34, 45, 45, 45, 65, 67, 87, 98 };
		int[] result = obj.searchRange(arr, 45);
		int count = result[1] - result[0] + 1;
		if (count == -1) {
			System.out.println("element doesnt exist in the array");
		} else {
			System.out.println("elememt occurs " + count + " times");
		}
	}
}