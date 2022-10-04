package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramSubStringSearch {
	// This function search for all permutations of pat[] in txt[]
	private List<Integer> anagramSearch(String s, String p) {
		List<Integer> ans = new ArrayList<>();
		int[] pArr = new int[26];
		int[] sArr = new int[26];

		// put all elements of pattern and its count
		for (char ch : p.toCharArray()) {
			pArr[ch - 'a']++;
		}

		int i = 0, j = 0;
		while (j < s.length()) {
			sArr[s.charAt(j) - 'a']++;

			if (j - i + 1 == p.length()) {
				if (Arrays.equals(pArr, sArr)) {
					ans.add(i);
				}
				// remove the ith char before sliding the window
				sArr[s.charAt(i) - 'a']--;
				i++;
			}
			j++;
		}
		return ans;
	}

	public static void main(String args[]) {
		AnagramSubStringSearch string = new AnagramSubStringSearch();
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> ids = string.anagramSearch(s, p);
		System.out.println(ids);
	}
}