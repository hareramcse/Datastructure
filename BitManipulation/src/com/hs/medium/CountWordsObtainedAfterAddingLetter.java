package com.hs.medium;

import java.util.HashSet;
import java.util.Set;

public class CountWordsObtainedAfterAddingLetter {
	public int wordCount(String[] startWords, String[] targetWords) {
		int ans = 0;
		Set<Integer> seen = new HashSet<>();
		for (String word : startWords) {
			seen.add(bitmask(word));
		}

		for (String word : targetWords) {
			int bitmask = bitmask(word);
			for (char c : word.toCharArray()) {
				if (seen.contains(bitmask - (1 << c - 'a'))) {
					ans++;
					break;
				}
			}
		}
		return ans;
	}

	private int bitmask(String word) {
		int res = 0;
		for (char c : word.toCharArray()) {
			res += 1 << c - 'a';
		}
		return res;
	}
}