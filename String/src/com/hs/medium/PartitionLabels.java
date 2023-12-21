package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		List<Integer> ans = new ArrayList<>();
		if (s.isEmpty())
			return ans;

		int[] lastIndex = new int[26];

		for (int i = 0; i < s.length(); i++) {
			lastIndex[s.charAt(i) - 'a'] = i;
		}

		int i = 0;
		while (i < s.length()) {
			int end = lastIndex[s.charAt(i) - 'a'];
			int j = i;
			while (j != end) {
				end = Math.max(end, lastIndex[s.charAt(j) - 'a']);
				j++;
			}
			ans.add(j - i + 1);
			i = j + 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		PartitionLabels obj = new PartitionLabels();
		String s = "ababcbacadefegdehijhklij";
		List<Integer> result = obj.partitionLabels(s);
		System.out.println(result);
	}
}