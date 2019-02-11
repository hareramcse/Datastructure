package com.hs.gs;

import java.util.Set;
import java.util.TreeSet;

public class Panagram {

	private static class PanagramDetector {
		private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

		public String findMissingLetters(String sentence) {
			Set<Character> missing = new TreeSet<Character>();
			for (int i = 0; i < ALPHABET.length(); i++) {
				missing.add(new Character(ALPHABET.charAt(i)));
			}

			String s = sentence.toLowerCase();

			for (int i = 0; i < s.length(); i++) {
				missing.remove(new Character(s.charAt(i)));
			}

			StringBuilder sb = new StringBuilder();
			for (Character c : missing) {
				sb.append(c.charValue());
			}

			return sb.toString();
		}

	}

	public static void main(String[] args) {
		PanagramDetector pd = new PanagramDetector();
		boolean success = true;

		success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
		success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

		if (success) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}
}