package com.hs.basic;

public class StringPermutationWithRecursion {

	private static void permutation(String perfix, String remaining) {
		int length = remaining.length();
		if (length == 0) {
			System.out.println(perfix);
		} else {
			for (int i = 0; i < length; i++) {
				String newPrefix = perfix + remaining.charAt(i);
				String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
				permutation(newPrefix, newRemaining);
			}
		}
	}

	public static void main(String[] args) {
		StringPermutationWithRecursion.permutation("", "abc");
	}
}
