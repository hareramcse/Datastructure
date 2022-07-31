package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		List<Integer> partionLength = new ArrayList<>();
		int[] lastIndex = new int[26];
		for (int i = 0; i < s.length(); i++) {
			lastIndex[s.charAt(i) - 'a'] = i;
		}

		int i = 0;
		while (i < s.length()) {
			int end = lastIndex[s.charAt(i) - 'a'];
			int j = i + 1;
			while (j != end) {
				end = Math.max(end, lastIndex[s.charAt(j++) - 'a']);
			}
			partionLength.add(j - i + 1);
			i = j + 1;
		}
		return partionLength;
	}

	public static void main(String[] args) {
		PartitionLabels obj = new PartitionLabels();
		String s = "ababcbacadefegdehijhklij";
		List<Integer> result = obj.partitionLabels(s);
		System.out.println(result);
	}
}