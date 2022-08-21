package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		TrieNode root = new TrieNode();
		Arrays.sort(products);
		
		for (String product : products) {
			TrieNode temp = root;
			for (char ch : product.toCharArray()) {
				if (temp.child[ch - 'a'] == null)
					temp.child[ch - 'a'] = new TrieNode();
				temp = temp.child[ch - 'a'];
				if (temp.suggestion.size() < 3)
					temp.suggestion.add(product);
			}
		}
		
		List<List<String>> ans = new ArrayList<>();
		for (char ch : searchWord.toCharArray()) {
			if (root != null)
				root = root.child[ch - 'a'];
			ans.add(root == null ? new ArrayList<>() : root.suggestion);
		}
		return ans;
	}

	public static void main(String[] args) {
		SearchSuggestionsSystem obj = new SearchSuggestionsSystem();
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord = "mouse";
		List<List<String>> result = obj.suggestedProducts(products, searchWord);
		System.out.println(result);
	}
}