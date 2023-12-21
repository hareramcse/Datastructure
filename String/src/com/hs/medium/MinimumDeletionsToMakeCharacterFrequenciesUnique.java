package com.hs.medium;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
	public int minDeletions(String s) {
		int[] fre = new int[26];
		for (char ch : s.toCharArray()) {
			fre[ch - 'a']++;
		}

		Set<Integer> set = new HashSet<>();
		int delete = 0;
		for (int count : fre) {
			while (count > 0 && set.contains(count)) {
				delete++;
				count--;
			}
			set.add(count);
		}
		return delete;
	}

	public static void main(String[] args) {
		MinimumDeletionsToMakeCharacterFrequenciesUnique obj = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
		String s = "aaabbbcc";
		int result = obj.minDeletions(s);
		System.out.println(result);
	}
}