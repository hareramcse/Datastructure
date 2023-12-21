package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitionig {
	public List<List<String>> partition(String s) {
		List<List<String>> ans = new ArrayList<>();
		List<String> path = new ArrayList<>();
		partitionUtil(0, s, path, ans);
		return ans;
	}

	private void partitionUtil(int index, String s, List<String> path, List<List<String>> ans) {
		if (index == s.length()) {
			ans.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s, index, i)) {
				path.add(s.substring(index, i + 1));
				partitionUtil(i + 1, s, path, ans);
				path.remove(path.size() - 1);
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
}
