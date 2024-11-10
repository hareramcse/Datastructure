package com.hs.medium;

import java.util.LinkedList;
import java.util.List;

public class TrieNode {
	TrieNode[] child = new TrieNode[26];
	boolean isWord;
	int prefixCount;
	List<String> suggestion=new LinkedList<>();
}
