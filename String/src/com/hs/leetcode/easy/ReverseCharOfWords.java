package com.hs.leetcode.easy;

public class ReverseCharOfWords {
	public String reverseWords(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		for (int j = 0; j < chars.length; j++) {
			if (chars[j] == ' ') {
				reverse(chars, i, j - 1);

				// jth char is white space so next non white space char will start from j + 1th
				// index
				i = j + 1;
			}
		}

		// this is to reverse the last word
		// as there will be no white space after last word
		reverse(chars, i, chars.length - 1);
		return new String(chars);
	}

	private void reverse(char[] chars, int i, int j) {
		while (i <= j) {
			char ch = chars[i];
			chars[i] = chars[j];
			chars[j] = ch;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		ReverseCharOfWords obj = new ReverseCharOfWords();
		String input = "Let's take LeetCode contest";
		String reverseWords = obj.reverseWords(input);
		System.out.println(reverseWords);
	}
}