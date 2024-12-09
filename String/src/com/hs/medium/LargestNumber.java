package com.hs.medium;

import java.util.Arrays;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

		if(arr[0].equals("0")) { // if input contains only zeros
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		LargestNumber obj = new LargestNumber();
		int[] nums = { 3, 30, 34, 5, 9 };
		String largestNumber = obj.largestNumber(nums);
		System.out.println(largestNumber);
	}
}