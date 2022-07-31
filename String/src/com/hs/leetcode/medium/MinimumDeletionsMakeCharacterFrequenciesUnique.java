package com.hs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsMakeCharacterFrequenciesUnique {
	public int minDeletions(String s) {
		int deletion = 0;
		int[] fre = new int[26];

		for (char ch : s.toCharArray()) {
			fre[ch - 'a']++;
		}

		Set<Integer> uniqueFre = new HashSet<>();
		for (int count : fre) {
			while (count > 0 && uniqueFre.contains(count)) {
				deletion++;
				count--;
			}
			uniqueFre.add(count);
		}

		return deletion;
	}

	public static void main(String[] args) {
		MinimumDeletionsMakeCharacterFrequenciesUnique obj = new MinimumDeletionsMakeCharacterFrequenciesUnique();
		String s = "aaabbbcc";
		int result = obj.minDeletions(s);
		System.out.println(result);
	}
}