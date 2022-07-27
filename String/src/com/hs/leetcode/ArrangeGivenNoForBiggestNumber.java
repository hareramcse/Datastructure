package com.hs.leetcode;

import java.util.Arrays;
import java.util.Comparator;

// 179. Largest Number Leetcode Medium
public class ArrangeGivenNoForBiggestNumber {

	public String largestNumber(int[] nums) {
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1)
			sb.deleteCharAt(0);

		return sb.toString();
	}

	public static void main(String[] args) {
		ArrangeGivenNoForBiggestNumber obj = new ArrangeGivenNoForBiggestNumber();
		int[] nums = { 0, 0 };
		String largestNumber = obj.largestNumber(nums);
		System.out.println(largestNumber);
	}
}