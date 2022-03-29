package com.hs.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class AnagramCount {

	private int findAnagrams(String str, String pattern) {
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();

		// put all elements of pattern and its count
		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(pattern.charAt(i)))
				map.put(pattern.charAt(i), map.get(pattern.charAt(i)) + 1);
			else
				map.put(pattern.charAt(i), 1);
		}

		int count = map.size();
		int i = 0, j = 0;
		while (j < str.length()) {
			// calculations
			if (map.containsKey(str.charAt(j))) {
				map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
				if (map.get(str.charAt(j)) == 0) {
					count--;
				}
			}
			if (j - i + 1 == pattern.length()) {
				// ans calculate
				if (count == 0) {
					ans++;
					// remove ans of i before sliding
				}
				if (map.containsKey(str.charAt(i))) {
					map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
					if (map.get(str.charAt(i)) == 1)
						count++;
				}
				i++;
			}
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		String pattern = "abaa";
		String str = "abaacdfghaabagjjkkbaaalhfmaaab";
		AnagramCount ac = new AnagramCount();
		int count = ac.findAnagrams(str, pattern);
		System.out.println(count);
	}
}