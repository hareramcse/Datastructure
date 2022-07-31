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

		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (temp.child[index] == null) {
				return false;
			}
			temp = temp.child[index];
		}
		return (temp != null && temp.isWord);
	}

	public static void main(String[] args) {
		DesignAddAndSearchWords obj = new DesignAddAndSearchWords();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		boolean result = obj.search("pad");
		System.out.println(result);
		result = obj.search("bad");
	}
}