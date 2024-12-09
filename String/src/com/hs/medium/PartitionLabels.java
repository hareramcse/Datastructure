package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0)
			return result;

		int[] lastIndex = new int[26];
		for (int i = 0; i < s.length(); i++) {
			lastIndex[s.charAt(i) - 'a'] = i;
		}

		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
			if (i == end) { // All characters that belong to the current partition have been included.
				result.add(end - start + 1); // Finalize the current partition
				start = i + 1; // Move to the next partition
			}
		}
		return result;
	}

	public static void main(String[] args) {
		PartitionLabels obj = new PartitionLabels();
		String s = "ababcbacadefegdehijhklij";
		List<Integer> result = obj.partitionLabels(s);
		System.out.println(result);
	}
}