package com.hs.easy;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int missingNumber = 0;
		for (int num : nums) {
			missingNumber = missingNumber ^ num;
		}

		for (int i = 0; i <= nums.length; i++) {
			missingNumber = missingNumber ^ i;
		}

		return missingNumber;
	}
}
