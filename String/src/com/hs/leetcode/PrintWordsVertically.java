package com.hs.leetcode;

import java.util.ArrayList;
import java.util.List;

// 1324. Print Words Vertically Leetcode Medium
public class PrintWordsVertically {
	public List<String> printVertically(String s) {
		List<String> res = new ArrayList<>();
		String[] words = s.split(" ");
		int maxLength = 0;
		for (String word : words) {
			maxLength = Math.max(maxLength, word.length());
		}
		for (int i = 0; i < maxLength; i++) {
			StringBuilder sb = new StringBuilder();
			for (String word : words) {
				if (i >= word.length()) {
					sb.append(" ");
				} else {
					sb.append(word.charAt(i));
				}
			}
			res.add(trimRight(sb.toString()));
		}
		return res;
	}

	// removes the white space from right till we dont get any char other than
	// white space
	private String trimRight(String word) {
		int pointer = word.length();
		while (--pointer > -1) {
			if (word.charAt(pointer) != ' ') {
				return word.substring(0, pointer + 1);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		PrintWordsVertically obj = new PrintWordsVertically();
		String input = "TO BE OR NOT TO BE";
		List<String> printVertically = obj.printVertically(input);
		System.out.println(printVertically);
	}
}