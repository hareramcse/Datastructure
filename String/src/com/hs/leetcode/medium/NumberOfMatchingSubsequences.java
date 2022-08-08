package com.hs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfMatchingSubsequences {
	public int numMatchingSubseq(String s, String[] words) {
		Set<String> subSeq = new HashSet<>();
		Set<String> notSubSeq = new HashSet<>();

		int count = 0;
		for (String word : words) {
			if (notSubSeq.contains(word)) {
				continue;
			} else if (subSeq.contains(word)) {
				count++;
			} else {
				if (isSubsequence(word, s)) {
					count++;
					subSeq.add(word);
				} else {
					notSubSeq.add(word);
				}
			}
		}
		return count;
	}

	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;

		int i = 0, j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j))
				i++;
			j++;
		}
		return i == s.length();
	}

	public static void main(String[] args) {
		NumberOfMatchingSubsequences obj = new NumberOfMatchingSubsequences();
		String s = "abcde";
		String[] words = { "a", "bb", "acd", "ace" };
		int result = obj.numMatchingSubseq(s, words);
		System.out.println(result);
	}
}