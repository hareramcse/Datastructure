package com.hs.leetcode.medium;

class TrieNode {
	TrieNode[] child = new TrieNode[26];
	boolean isWord;
}

public class DesignAddAndSearchWords {

	TrieNode root;

	public DesignAddAndSearchWords() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode temp = root;
		for (char ch : word.toCharArray()) {
			if (temp.child[ch - 'a'] == null) {
				temp.child[ch - 'a'] = new TrieNode();
			}
			temp = temp.child[ch - 'a'];
		}
		temp.isWord = true;
	}

	public boolean search(String word) {
		TrieNode temp = root;
		return search(word, 0, temp);
	}

	public boolean search(String word, int index, TrieNode temp) {
		if (temp == null)
			return false;
		if (index == word.length())
			return temp.isWord;

		char ch = word.charAt(index);
		if (ch == '.') {
			for (int k = 0; k < 26; k++) {
				if (search(word, index + 1, temp.child[k]))
					return true;
			}
		} else {
			if (search(word, index + 1, temp.child[ch - 'a']))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DesignAddAndSearchWords obj = new DesignAddAndSearchWords();
		obj.addWord("bad");
		boolean result = obj.search("pad");
		System.out.println(result);
		result = obj.search("bad");
		System.out.println(result);
	}
}