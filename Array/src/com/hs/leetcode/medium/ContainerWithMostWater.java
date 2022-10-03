package com.hs.leetcode.medium;

public class ContainerWithMostWater {
	// TLE in leetcode
	public int maxAreaBruteForce(int[] height) {
		int maxWater = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int lenght = Math.min(height[i], height[j]);
				int width = j - i;
				maxWater = Math.max(maxWater, lenght * width);
			}
		}
		return maxWater;
	}

	public int maxAreaOptimal(int[] height) {
		int maxWater = 0;
		int start = 0, end = height.length - 1;
		while (start < end) {
			int minHight = Math.min(height[start], height[end]);
			int width = end - start;
			maxWater = Math.max(maxWater, minHight * width);
			if (height[start] > height[end]) {
				end--;
			} else {
				start++;
			}
		}
		return maxWater;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		ContainerWithMostWater obj = new ContainerWithMostWater();
		int maxArea = obj.maxAreaOptimal(arr);
		System.out.println(maxArea);
	}
}