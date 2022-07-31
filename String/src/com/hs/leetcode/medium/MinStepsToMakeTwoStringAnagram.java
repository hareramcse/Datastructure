package com.hs.leetcode.medium;

public class MinStepsToMakeTwoStringAnagram {
	public int minSteps(String s, String t) {
		int[] freqS = freqMap(s);
		int[] freqT = freqMap(t);
		
		int res = 0;
		for (int i = 0; i < 26; i++) {
			int maxChar = Math.max(freqS[i], freqT[i]);
			res += (maxChar - freqS[i]) + (maxChar - freqT[i]);
		}
		return res;
	}

	private int[] freqMap(String s) {
		int[] fre = new int[26];
		for (char ch : s.toCharArray()) {
			fre[ch - 'a']++;
		}
		return fre;
	}

	public static void main(String[] args) {
		MinStepsToMakeTwoStringAnagram obj = new MinStepsToMakeTwoStringAnagram();
		String s = "leetcode";
		String t = "practice";
		int result = obj.minSteps(s, t);
		System.out.println(result);
	}
}