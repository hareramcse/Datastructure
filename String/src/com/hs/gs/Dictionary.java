package com.hs.gs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {
	private Map<String, List<String>> sortedLettersToWords = new HashMap<>();

	public Dictionary(String[] entries) {
		for (String entry : entries) {
			String sortedLetters = Stream.of(entry.split("")).sorted().collect(Collectors.joining());
			sortedLettersToWords.computeIfAbsent(sortedLetters, list -> new LinkedList<String>());
			sortedLettersToWords.get(sortedLetters).add(entry);
		}
	}

	public List<String> getEntriesForSortedLetters(String sortedLetters) {
		return sortedLettersToWords.get(sortedLetters);
	}

	public static Set<String> combinationsDroppingOneLetter(Set<String> lettersCombinations) {
		Set<String> oneLetterLessSet = new HashSet<>();
		for (String letters : lettersCombinations) {
			if (letters.length() > 1) {
				for (int i = 0; i < letters.length(); i++) {
					oneLetterLessSet.add(letters.substring(0, i) + letters.substring(i + 1, letters.length()));
				}
			}
		}
		return oneLetterLessSet;
	}

	public static Set<String> longestWord(String letters, Dictionary dictionary) {
		// To support ? wild card could expand all possibilites here. A better solution
		// would be Tree/Trie based
		// Set with one entry of letters sorted
		Set<String> considerLettersSet = new HashSet<>(
				Arrays.asList(Stream.of(letters.split("")).sorted().reduce("", String::concat)));

		while (considerLettersSet.size() > 0) {
			// Get list of words in dictionary that match any of the set of sorted letters
			List<String> allFoundInDict = considerLettersSet.stream()
					.map(lets -> dictionary.getEntriesForSortedLetters(lets)).filter(l -> l != null)
					.flatMap(l -> l.stream()).collect(Collectors.toList());
			if (allFoundInDict.size() > 0) {
				return new HashSet<String>(allFoundInDict);
			}
			// Next time round loop will consider combinations of sorted letters with one
			// less character
			considerLettersSet = combinationsDroppingOneLetter(considerLettersSet);
		}
		return new HashSet<>();
	}

	public static boolean testDroppingLetter(List<String> letters, List<String> expectedResult) {
		Set<String> actualOutput = combinationsDroppingOneLetter(new HashSet<String>(letters));
		return (new HashSet<String>(expectedResult)).equals(actualOutput);
	}

	public static boolean doTestsPass() {
		// Not bothering to test letters for null, empty string or non lower-case
		boolean result = testDroppingLetter(Arrays.asList("abc"), Arrays.asList("ab", "bc", "ac"));
		result = result && testDroppingLetter(Arrays.asList("abb"), Arrays.asList("ab", "bb"));
		result = result && testDroppingLetter(Arrays.asList("ab", "bb"), Arrays.asList("a", "b"));
		result = result && testDroppingLetter(Arrays.asList("a", "b"), Arrays.asList());

		Dictionary dict = new Dictionary(
				new String[] { "to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana" });

		result = result && new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
		result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));
		result = result
				&& new HashSet<String>(Arrays.asList("doe", "toe", "dog", "god")).equals(longestWord("oetdg", dict));
		result = result && new HashSet<String>(Arrays.asList("book")).equals(longestWord("obokt", dict));
		result = result && new HashSet<String>(Arrays.asList("banana")).equals(longestWord("nanabaook", dict));
		result = result && new HashSet<String>().equals(longestWord("aeiou", dict));
		result = result && new HashSet<String>().equals(longestWord("a", dict));

		return result;
	}

	/**
	 * Execution entry point.
	 */
	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.err.println("There are test failures");
		}
	}
}