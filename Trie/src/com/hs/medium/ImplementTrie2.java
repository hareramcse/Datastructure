package com.hs.medium;

public class ImplementTrie2 {
	TrieNode root;

	public ImplementTrie2() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode temp = root;

		for (char ch : word.toCharArray()) {
			if (temp.child[ch - 'a'] == null) {
				temp.child[ch - 'a'] = new TrieNode();
			}
			temp = temp.child[ch - 'a'];
			temp.prefixCount += 1;
		}
		temp.wordCount += 1;
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

	public int countWordsEqualTo(String word) {
		TrieNode node = getNode(word);
		int count = node != null ? node.wordCount : 0;
		return count;
	}

	public int countWordsStartingWith(String word) {
		TrieNode node = getNode(word);
		int count = node != null ? node.prefixCount : 0;
		return count;
	}

	public void erase(String word) {
		TrieNode node = getNode(word);
		node.wordCount -= 1;
	}

	public static void main(String[] args) {
		ImplementTrie2 obj = new ImplementTrie2();
		obj.insert("apple");
		obj.insert("apple");
		obj.insert("apps");
		obj.insert("apps");
		String word1 = "apps";
		System.out.println("Count Words Equal to " + word1 + " " + obj.countWordsEqualTo(word1));
		String word2 = "abc";
		System.out.println("Count Words Equal to " + word2 + " " + obj.countWordsEqualTo(word2));
		String word3 = "ap";
		System.out.println("Count Words Starting With " + word3 + " " + obj.countWordsStartingWith(word3));
		String word4 = "appl";
		System.out.println("Count Words Starting With " + word4 + " " + obj.countWordsStartingWith(word4));
		obj.erase(word1);
		System.out.println("Count Words equal to " + word1 + " " + obj.countWordsEqualTo(word1));
	}
}