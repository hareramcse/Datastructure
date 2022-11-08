package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1)
			sb.deleteCharAt(0);

		return sb.toString();
	}

	public static void main(String[] args) {
		LargestNumber obj = new LargestNumber();
		int[] nums = { 3, 30, 34, 5, 9 };
		String largestNumber = obj.largestNumber(nums);
		System.out.println(largestNumber);
	}
}