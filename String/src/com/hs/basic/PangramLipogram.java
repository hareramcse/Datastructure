package com.hs.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PangramLipogram {

	// function to check for Pangrammatic Lipogram
	static void panLipogramChecker(String s) {

		// using map to keep count of the
		// occurence of each letter
		HashMap<Character, Integer> mp = new HashMap<>();

		for (char c = 'a'; c <= 'z'; c++) {
			mp.put(c, 0);
		}

		s = s.toLowerCase();

		int i, n = s.length();
		for (i = 0; i <= n - 1; i++) {
			if (Character.isAlphabetic(s.charAt(i))) {

				// increment count of characters in
				// dictionary
				mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
			}
		}
		int count_zero = 0;

		// Getting an iterator
		Iterator hmIterator = mp.entrySet().iterator();

		while (hmIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry) hmIterator.next();
			int marks = ((int) mapElement.getValue());

			if (marks == 0)
				count_zero++;
		}
		if (count_zero > 1) {
			System.out.println("Not a pangram, but might be a lipogram.");
		} else if (count_zero == 1) {
			System.out.println("Pangrammatic Lipogram.");
		} else if (count_zero < 1) {
			System.out.println("Pangram.");
		}
	}

	public static void main(String[] args) {
		panLipogramChecker("The quick brown fox jumped over the lazy dog");
		panLipogramChecker("The quick brown fox jumps over the lazy dog");
		panLipogramChecker("The quick brown fox jum over the lazy dog");
	}

}