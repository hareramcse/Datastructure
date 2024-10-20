package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<>();
		int[] pFre = new int[26];
		int[] sFre = new int[26];

		for (char ch : p.toCharArray()) {
			pFre[ch - 'a']++;
		}

		int i = 0, j = 0;
		while (j < s.length()) {
			sFre[s.charAt(j) - 'a']++;

			if (j - i + 1 == p.length()) {
				if (Arrays.equals(pFre, sFre)) {
					ans.add(i);
				}
				sFre[s.charAt(i) - 'a']--;
				i++;
			}
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		String str = "cbaebabacd";
		String pattern = "abc";
		FindAllAnagramsInString obj = new FindAllAnagramsInString();
		List<Integer> result = obj.findAnagrams(str, pattern);
		System.out.println(result);
	}
}