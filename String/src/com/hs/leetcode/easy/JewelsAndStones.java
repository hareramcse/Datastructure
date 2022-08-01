package com.hs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
	public int numJewelsInStones(String jewels, String stones) {
		Set<Character> jSet = new HashSet<>();
		for (char ch : jewels.toCharArray()) {
			jSet.add(ch);
		}

		int ans = 0;
		for (char ch : stones.toCharArray()) {
			if (jSet.contains(ch))
				ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		JewelsAndStones obj = new JewelsAndStones();
		String jewels = "aA";
		String stones = "aAAbbbb";
		int result = obj.numJewelsInStones(jewels, stones);
		System.out.println(result);
	}
}