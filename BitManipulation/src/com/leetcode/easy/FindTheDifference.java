package com.leetcode.easy;

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		char ans = '0';
		for (char c : s.toCharArray()) {
			ans ^= c;
		}
		for (char c : t.toCharArray()) {
			ans ^= c;
		}

		ans ^= '0';
		return ans;
	}

	public static void main(String[] args) {
		FindTheDifference obj = new FindTheDifference();
		String s = "abcd";
		String t = "abcde";
		char result = obj.findTheDifference(s, t);
		System.out.println(result);
	}
}
