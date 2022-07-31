package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestionsSystem {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> ans = new ArrayList<>();

		Arrays.sort(products);

		TreeMap<String, Integer> map = new TreeMap<>();
		List<String> productsList = Arrays.asList(products);
		for (int i = 0; i < products.length; i++) {
			map.put(products[i], i);
		}
		String key = "";
		for (char ch : searchWord.toCharArray()) {
			key += ch;
			String ceiling = map.ceilingKey(key);
			String floor = map.floorKey(key + "{");
			if (ceiling == null || floor == null)
				break;

			ans.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
		}
		while (ans.size() < searchWord.length())
			ans.add(new ArrayList<>());

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