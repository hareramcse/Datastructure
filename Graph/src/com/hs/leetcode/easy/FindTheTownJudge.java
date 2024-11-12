package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {
	public int findJudge(int n, int[][] trust) {
		if (trust.length == 0) {
			return n == 1 ? 1 : -1;
		}

		Map<Integer, Integer> trustCount = new HashMap<>();
		Set<Integer> trusters = new HashSet<>();

		for (int[] relation : trust) {
			int a = relation[0]; // person a trusts
			int b = relation[1]; // person b is trusted by a

			trusters.add(a); // a trusts someone
			trustCount.put(b, trustCount.getOrDefault(b, 0) + 1); // count how many people trust b
		}

		// Now find the judge
		for (int key : trustCount.keySet()) {
			// Judge should not trust anyone and should be trusted by exactly n-1 people
			if (!trusters.contains(key) && trustCount.get(key) == n - 1) {
				return key;
			}
		}
		return -1; // No judge found
	}
}
