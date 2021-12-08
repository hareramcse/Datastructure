package com.hs.occurance;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FrequentWord {

	// Function returns word with highest frequency
	static String findWord(String[] arr) {

		// Create HashMap to store word and it's frequency
		HashMap<String, Integer> hs = new HashMap<String, Integer>();

		// Iterate through array of words
		for (int i = 0; i < arr.length; i++) {
			// If word already exist in HashMap then increase it's count by 1
			if (hs.containsKey(arr[i])) {
				hs.put(arr[i], hs.get(arr[i]) + 1);
			}
			// Otherwise add word to HashMap
			else {
				hs.put(arr[i], 1);
			}
		}

		// Create set to iterate over HashMap
		Set<Map.Entry<String, Integer>> set = hs.entrySet();
		String key = "";
		int value = 0;

		for (Map.Entry<String, Integer> me : set) {
			// Check for word having highest frequency
			if (me.getValue() > value) {
				value = me.getValue();
				key = me.getKey();
			}
		}

		// Return word having highest frequency
		return key;
	}

	// Driver code
	public static void main(String[] args) {
		String arr[] = { "geeks", "for", "geeks", "a", "portal", "to", "learn", "can", "be", "computer", "science",
				"zoom", "yup", "fire", "in", "be", "data", "geeks" };
		String sol = findWord(arr);

		// Print word having highest frequency
		System.out.println(sol);
	}

}