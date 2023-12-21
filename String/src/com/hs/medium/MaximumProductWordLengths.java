package com.hs.medium;

public class MaximumProductWordLengths {
	public int maxProduct(String[] words) {
		int n = words.length;
		int[] state = new int[n];

		for (int i = 0; i < n; i++) {
			state[i] = getState(words[i]);
		}

		int maxProduct = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((state[i] & state[j]) == 0) {
					maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
				}
			}
		}
		return maxProduct;
	}

	private int getState(String word) {
		int state = 0;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			state |= 1 << index;
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