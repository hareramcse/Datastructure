package com.hs.gs;

public class IsPowerOf10 {
	public static boolean isPowerOf10(int x) {
		for (int i = 1; i <= x; i *= 10) {
			if (i == x) {
				return true;
			}

			if (i > Integer.MAX_VALUE / 10) {
				return false;
			}
		}
		return false;
	}

	public static boolean doTestsPass() {
		int[] isPowerList = { 1, 10, 100, 10000, 1000000000 };
		int[] isNotPowerList = { 3, 50, 0, -1, -10, -50, -53, 2000000000 };

		for (int i : isPowerList) {
			if (!isPowerOf10(i)) {
				System.out.println("Test failed for: " + i);
				return false;
			}
		}

		for (int i : isNotPowerList) {
			if (isPowerOf10(i)) {
				System.out.println("Test failed for: " + i);
				return false;
			}
		}

		System.out.println("All tested passed");
		return true;
	};

	public static void main(String args[]) {
		doTestsPass();
	}
}
