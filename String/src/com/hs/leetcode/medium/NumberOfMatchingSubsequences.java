package com.hs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfMatchingSubsequences {
	public int numMatchingSubseq(String s, String[] words) {
		Set<String> subS = new HashSet<>();
		Set<String> notSubS = new HashSet<>();

		int count = 0;
		for (String word : words) {
			if (subS.contains(word)) {
				count++;
			} else if (notSubS.contains(word)) {
				continue;
			} else {
				if (isSubsequence(s, word)) {
					count++;
					subS.add(word);
				} else {
					notSubS.add(word);
				}
			}
		}
		return count;
	}

	private boolean isSubsequence(String s, String word) {
		int index = 0;
		for (char ch : word.toCharArray()) {
			index = s.indexOf(ch, index);
			if (index == -1) {
				return false;
			}
			index++;
		}
		return true;
	}

	public static void main(String[] args) {
		NumberOfMatchingSubsequences obj = new NumberOfMatchingSubsequences();
		String s = "abcde";
		String[] words = { "a", "bb", "acd", "ace" };
		int result = obj.numMatchingSubseq(s, words);
		System.out.println(result);
	}
}