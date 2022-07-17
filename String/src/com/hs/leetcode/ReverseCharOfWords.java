package com.hs.leetcode;

// 557. Reverse Words in a String III Leetcode easy
public class ReverseCharOfWords {
	public String reverseWords(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		for (int j = 0; j < chars.length; j++) {
			if (chars[j] == ' ') {
				reverse(chars, i, j - 1);
				i = j + 1;
			}
		}
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
