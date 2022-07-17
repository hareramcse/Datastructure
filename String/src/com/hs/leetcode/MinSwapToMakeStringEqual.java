package com.hs.leetcode;

// 1247. Minimum Swaps to Make Strings Equal Leetcode Medium
public class MinSwapToMakeStringEqual {

	public int minimumSwap(String s1, String s2) {
		char[] charS1 = s1.toCharArray();
		char[] charS2 = s2.toCharArray();

		if (charS1.length != charS2.length)
			return -1;
		int xy = 0, yx = 0;
		for (int i = 0; i < charS1.length; i++) {
			if (charS1[i] == 'x' && charS2[i] == 'y')
				xy++;
			else if (charS1[i] == 'y' && charS2[i] == 'x')
				yx++;
		}
		return (xy + yx) % 2 == 0 ? xy / 2 + yx / 2 + xy % 2 + yx % 2 : -1;
	}

	public static void main(String[] args) {
		MinSwapToMakeStringEqual obj = new MinSwapToMakeStringEqual();
		String s1 = "xx";
		String s2 = "yy";

		int minimumSwap = obj.minimumSwap(s1, s2);
		System.out.println(minimumSwap);
	}
}
