package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitionig {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), s, 0);
		return result;
	}

	public void backtrack(List<List<String>> result, List<String> list, String s, int start) {
		if (start == s.length()) {
			result.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				list.add(s.substring(start, i + 1));
				backtrack(result, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromPartitionig obj = new PalindromPartitionig();
		String s = "aab";
		List<List<String>> result = obj.partition(s);
		System.out.println(result);
	}
}
