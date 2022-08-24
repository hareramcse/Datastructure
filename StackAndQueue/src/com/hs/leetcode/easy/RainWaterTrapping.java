package com.hs.leetcode.easy;

// 42. Trapping Rain Water Leetcode
public class RainWaterTrapping {
	public int trap(int[] height) {
		int n = height.length;
		int maxl[] = new int[n];
		int maxr[] = new int[n];

		maxl[0] = height[0];
		for (int i = 1; i < n; i++) {
			maxl[i] = Math.max(maxl[i - 1], height[i]);
		}

		maxr[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maxr[i] = Math.max(maxr[i + 1], height[i]);
		}

		int water[] = new int[n];
		for (int i = 0; i < n; i++) {
			water[i] = Math.min(maxl[i], maxr[i]) - height[i];
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += water[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		RainWaterTrapping rwt = new RainWaterTrapping();
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		int res = rwt.trap(arr);
		System.out.println(res);
	}
}