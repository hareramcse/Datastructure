package com.hs.leetcode.easy;

import java.util.Arrays;

public class ShortestDistanceToChar {
	public int[] shortestToChar(String s, char c) {
		int n = s.length();
		int[] output = new int[n];
		int position = -n;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == c) {
				position = i;
			}
			output[i] = i - position;
		}

		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == c) {
				position = i;
			}
			output[i] = Math.min(output[i], Math.abs(i - position));
		}

		return output;
	}

	public static void main(String[] args) {
		ShortestDistanceToChar obj = new ShortestDistanceToChar();
		String s = "loveleetcode";
		char c = 'e';
		int[] result = obj.shortestToChar(s, c);
		System.out.println(Arrays.toString(result));
	}
}