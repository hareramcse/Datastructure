package com.hs.leetcode.medium;

public class ImplementTrie {
	TrieNode root;

	public ImplementTrie() {
		root = new TrieNode();
	}

	public void insert(String word) {
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
		TrieNode node = getNode(word);
		return node != null && node.isWord;
	}

	public boolean startsWith(String prefix) {
		return getNode(prefix) != null;
	}

	private TrieNode getNode(String word) {
		TrieNode temp = root;

		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (temp.child[index] == null) {
				return null;
			}
			temp = temp.child[index];
		}
		return temp;
	}

	public static void main(String[] args) {
		ImplementTrie obj = new ImplementTrie();
		obj.insert("apple");
		boolean result = obj.search("apple");
		System.out.println(result);
		result = obj.search("app");
		System.out.println(result);
		result = obj.startsWith("app");
		System.out.println(result);
		obj.insert("app");
		result = obj.search("app");
		System.out.println(result);
	}
}