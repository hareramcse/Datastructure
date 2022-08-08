package com.hs.slidingwindow.fixed;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		Map<Character, Integer> dict = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			dict.put(ch, dict.getOrDefault(ch, 0) + 1);
		}

		Map<Character, Integer> temp = new HashMap<>();
		int i = 0;
		for (int j = 0; j < s2.length(); j++) {
			if (!dict.containsKey(s2.charAt(j))) {
				i = j + 1;
				temp.clear(); // clear counter
				continue;
			}

			int count = temp.getOrDefault(s2.charAt(j), 0);
			if (count == 0 || count < dict.get(s2.charAt(j))) {
				temp.put(s2.charAt(j), count + 1);

				if (j - i + 1 == s1.length()) {
					return true;
				}
			} else {
				while (i < j) {
					if (s2.charAt(i) == s2.charAt(j)) {
						i++;
						break;
					}

					temp.put(s2.charAt(i), temp.get(s2.charAt(i)) - 1);
					i++;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		PermutationInString obj = new PermutationInString();
		String s1 = "ab";
		String s2 = "eidbaooo";
		boolean checkInclusion = obj.checkInclusion(s1, s2);
		System.out.println(checkInclusion);
	}
}