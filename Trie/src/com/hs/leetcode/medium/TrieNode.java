package com.hs.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class TrieNode {
	TrieNode[] child = new TrieNode[26];
	boolean isWord;
	int wordCount;
	int prefixCount;
	List<String> suggestion=new LinkedList<>();
}
