package com.hs.medium;

public class CountDistinctSubstring {
	TrieNode root;

	public CountDistinctSubstring() {
		root = new TrieNode();
	}

	public int insert(String word) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			TrieNode temp = root;
			for (int j = i; j < word.length(); j++) {
				if (temp.child[word.charAt(i) - 'a'] == null) {
					temp.child[word.charAt(i) - 'a'] = new TrieNode();
					count++;
				}
				temp = temp.child[word.charAt(i) - 'a'];
			}
		}
		return count + 1;
	}

	public static void main(String[] args) {
		CountDistinctSubstring obj = new CountDistinctSubstring();
		String str = "abc";
		int result = obj.insert(str);
		System.out.println(result);
	}
}