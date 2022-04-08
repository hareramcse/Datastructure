package com.hs.imp;

public class RainWaterTrapping {
	private int trap(int[] height) {
		int n = height.length;
		int mxl[] = new int[n];
		int mxr[] = new int[n];

		mxl[0] = height[0];
		for (int i = 1; i < n; i++) {
			mxl[i] = Math.max(mxl[i - 1], height[i]);
		}

		mxr[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			mxr[i] = Math.max(mxr[i + 1], height[i]);
		}

		int water[] = new int[n];
		for (int i = 0; i < n; i++) {
			water[i] = Math.min(mxl[i], mxr[i]) - height[i];
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