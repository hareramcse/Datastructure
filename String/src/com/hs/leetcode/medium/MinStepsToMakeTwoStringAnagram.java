package com.hs.leetcode.medium;

public class MinStepsToMakeTwoStringAnagram {
	public int minSteps(String s, String t) {
		int[] counts = new int[26];

		for (int i = 0; i < s.length(); i++) {
			counts[s.charAt(i) - 'a']++;
			counts[t.charAt(i) - 'a']--;
		}

		int res = 0;
		for (int count : counts) {
			if (count > 0) {
				res += count;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MinStepsToMakeTwoStringAnagram obj = new MinStepsToMakeTwoStringAnagram();
		String s = "leetcode";
		String t = "practice";
		int result = obj.minSteps(s, t);
		System.out.println(result);
	}
}