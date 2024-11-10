package com.hs.medium;

public class LongestWordWithAllPrefixes {
	TrieNode root;

	public LongestWordWithAllPrefixes() {
		root = new TrieNode();
	}

	public String longestWord(String[] words) {
		for (String word : words) {
			insert(word);
		}

		String longest = "";
		for (String word : words) {
			if (startsWith(word)) {
				if (word.length() > longest.length()) {
					longest = word;
				} else if (word.length() == longest.length() && word.compareTo(longest) < 0) {
					longest = word;
				}
			}
		}

		if (longest == "")
			return "None";
		return longest;
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
			if (temp.child[ch - 'a'] == null) {
				return null;
			}
			temp = temp.child[ch - 'a'];
		}
		return temp;
	}

	public static void main(String[] args) {
		LongestWordWithAllPrefixes obj = new LongestWordWithAllPrefixes();
		String[] words = { "l", "le", "lee", "leet", "leetc", "leetco", "leetcod", "leetcode", "leetpode" };
		String result = obj.longestWord(words);
		System.out.println(result);
	}
}