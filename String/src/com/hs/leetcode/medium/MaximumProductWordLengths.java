package com.hs.leetcode.medium;

public class MaximumProductWordLengths {
	public int maxProduct(String[] words) {
		int len = words.length;
		int[] state = new int[len];

		for (int i = 0; i < len; i++) {
			state[i] = getState(words[i]);
		}

		int maxProduct = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if ((state[i] & state[j]) == 0) {
					if (words[i].length() * words[j].length() > maxProduct) {
						maxProduct = words[i].length() * words[j].length();
					}
				}
			}
		}
		return maxProduct;
	}

	private int getState(String s) {
		int state = 0;
		for (char ch : s.toCharArray()) {
			int index = ch - 'a';
			state |= 1 << (index);
		}
		return state;
	}

	public static void main(String[] args) {
		MaximumProductWordLengths obj = new MaximumProductWordLengths();
		String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		int result = obj.maxProduct(words);
		System.out.println(result);
	}
}