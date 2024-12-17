package com.hs.easy;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int candidate = 0;
		int count = 0;

		// Finding candidate
		for (int num : nums) {
			if (candidate == num) {
				count++;
			} else if (count == 0) {
				candidate = num;
				count = 1;
			} else {
				count--;
			}
		}

		// Verifying candidate
		count = 0;
		for (int num : nums) {
			if (candidate == num) {
				count++;
			}
		}

		// Checking if candidate is majority element
		if (count > nums.length / 2) {
			return candidate;
		} else {
			throw new IllegalArgumentException("No majority element");
		}
	}

	public static void main(String[] args) {
		MajorityElement obj = new MajorityElement();
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int result = obj.majorityElement(nums);
		System.out.println(result);
	}
}