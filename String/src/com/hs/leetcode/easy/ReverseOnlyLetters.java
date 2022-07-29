package com.hs.leetcode.easy;

public class ReverseOnlyLetters {
	public String reverseOnlyLetters(String s) {
		char[] characters = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetter(s.charAt(i)))
				i++;
			while (j > i && !Character.isLetter(s.charAt(i)))
				j--;

			char temp = characters[i];
			characters[i++] = characters[j];
			characters[j--] = temp;
		}

		return new String(characters);
	}

	public static void main(String[] args) {
		ReverseOnlyLetters obj = new ReverseOnlyLetters();
		String s = "ab-cd";
		String result = obj.reverseOnlyLetters(s);
		System.out.println(result);
	}
}