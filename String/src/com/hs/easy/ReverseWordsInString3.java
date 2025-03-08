package com.hs.easy;

public class ReverseWordsInString3 {
	public String reverseWords(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		for (int j = 0; j < chars.length; j++) {
			if (chars[j] == ' ') {
				reverse(chars, i, j - 1);
				i = j + 1; // Move i to the starting index of the next word
			}
		}

		// reverse the last word as there will be no white space after last word
		reverse(chars, i, chars.length - 1);
		return new String(chars);
	}

	private void reverse(char[] chars, int i, int j) {
		while (i < j) {
			char ch = chars[i];
			chars[i] = chars[j];
			chars[j] = ch;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		ReverseWordsInString3 obj = new ReverseWordsInString3();
		String input = "Let's take online contest";
		String reverseWords = obj.reverseWords(input);
		System.out.println(reverseWords);
	}
}