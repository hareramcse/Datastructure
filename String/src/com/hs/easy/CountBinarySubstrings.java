package com.hs.easy;

public class CountBinarySubstrings {
	public int countBinarySubstrings(String s) {
		int count = 0, i = 1, prev = 0, curr = 1;
		while (i < s.length()) {
			if (s.charAt(i - 1) != s.charAt(i)) {
				count += Math.min(prev, curr);
				prev = curr;
				curr = 1;
			} else {
				curr++;
			}
			i++;
		}
		return count += Math.min(prev, curr);
	}

	public static void main(String[] args) {
		CountBinarySubstrings obj = new CountBinarySubstrings();
		String s = "10101";
		int result = obj.countBinarySubstrings(s);
		System.out.println(result);
	}
}