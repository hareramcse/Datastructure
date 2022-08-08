package com.hs.leetcode.medium;

public class ReverseWord {
	public String reverseWords(String s) {
		if (s.isEmpty()) {
			return "";
		}

		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]);
				sb.append(" ");
			}
		}
		
		// delete the last space from the string.
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}

	public static void main(String[] args) {
		ReverseWord obj = new ReverseWord();
		String input = "the sky is blue";
		String reverseWords = obj.reverseWords(input);
		System.out.println(reverseWords);
	}
}