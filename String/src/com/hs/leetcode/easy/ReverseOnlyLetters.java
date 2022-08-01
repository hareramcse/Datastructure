package com.hs.leetcode.easy;

public class ReverseOnlyLetters {
	public String reverseOnlyLetters(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		int j = chars.length - 1;

		while (i < j) {
			while (i < j && !Character.isLetter(chars[i]))
				i++;
			while (j > i && !Character.isLetter(chars[j]))
				j--;

			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}

		return new String(chars);
	}

	public static void main(String[] args) {
		ReverseOnlyLetters obj = new ReverseOnlyLetters();
		String s = "ab-cd";
		String result = obj.reverseOnlyLetters(s);
		System.out.println(result);
	}
}