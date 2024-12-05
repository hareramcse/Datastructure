package com.hs.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();

		for (Integer num : nums2) {
			while (!stack.isEmpty() && num > stack.peek()) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}

		while (!stack.isEmpty()) {
			map.put(stack.pop(), -1);
		}

		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			result[i] = map.getOrDefault(nums1[i], -1);
		}

		return result;
	}

	public static void main(String[] args) {
		NextGreaterElement obj = new NextGreaterElement();
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };
		int[] result = obj.nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.toString(result));
	}
}
