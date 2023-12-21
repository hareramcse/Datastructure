package com.hs.medium;

// find the leftMax and rightMax for each building
// water on each building will be min(leftMax - rightMax) - height[i] 
public class TrappingRainWater {
	public int trap(int[] heights) {
		int left[] = new int[heights.length], right[] = new int[heights.length], max = heights[0], res = 0;

		for (int i = 0; i < heights.length; i++) {
			left[i] = Math.max(heights[i], max);
			max = left[i];
		}

		max = heights[heights.length - 1];
		for (int i = heights.length - 1; i >= 0; i--) {
			right[i] = Math.max(heights[i], max);
			max = right[i];
		}

		for (int i = 0; i < heights.length; i++) {
			res = res + Math.min(left[i], right[i]) - heights[i];
		}
		return res;
	}

	public int trapWithTwoPointer(int[] heights) {
		if (heights.length == 0)
			return 0;

		int left = 0, right = heights.length - 1;
		int leftMax = heights[left], rightMax = heights[right];
		int res = 0;

		while (left < right) {
			if (leftMax < rightMax) {
				left++;
				leftMax = Math.max(leftMax, heights[left]);
				res += leftMax - heights[left];
			} else {
				right--;
				rightMax = Math.max(rightMax, heights[right]);
				res += rightMax - heights[right];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TrappingRainWater rwt = new TrappingRainWater();
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		int res = rwt.trap(arr);
		System.out.println(res);
	}
}