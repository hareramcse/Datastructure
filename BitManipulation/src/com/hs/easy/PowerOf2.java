package com.hs.easy;

public class PowerOf2 {
	public boolean isPowerOfTwo(int n) {
		if (n == 0 || n == Integer.MIN_VALUE)
			return false;

		int ans = n & (n - 1);
		return ans == 0;
	}

	public static void main(String[] args) {
		PowerOf2 obj = new PowerOf2();
		int n = 16;
		boolean result = obj.isPowerOfTwo(n);
		System.out.println(result);
	}
}
