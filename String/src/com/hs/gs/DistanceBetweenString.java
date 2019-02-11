package com.hs.gs;

public class DistanceBetweenString {
	public static double shortestDistance(String document, String word1, String word2) {
		String[] words = document.split("[,. ]");

		int index = 0;
		double shortest = document.length();
		double word1Loc = 0;
		double word2Loc = 0;
		for (String word : words) {
			if (word.equalsIgnoreCase(word1)) {
				word1Loc = index + (word.length() / 2d);
			} else if (word.equalsIgnoreCase(word2)) {
				word2Loc = index + (word.length() / 2d);
			}

			if (word1Loc > 0 && word2Loc > 0) {
				double current = Math.abs(word1Loc - word2Loc);
				if (current < shortest) {
					shortest = current;
				}
			}

			index += word.length() + 1;
		}

		if (word1Loc == 0 || word2Loc == 0) {
			return -1;
		}

		return shortest;
	}

	/**
	 * Returns true if the tests pass. Otherwise, false.
	 */
	public static boolean doTestsPass() {
		// todo: implement more tests if you'd like
		return shortestDistance(_document, "and", "graphic") == 6d
				&& shortestDistance(_document, "transfer", "it") == 14d
				&& shortestDistance(_document, "Design", "filler") == 25d;
	}

	/**
	 * Execution entry point.
	 */
	public static void main(String[] args) {
		// Run the tests
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}
	}

	private static final String _document;
	static {
		StringBuffer sb = new StringBuffer();
		sb.append(
				"In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
		sb.append(
				" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
		sb.append(
				" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

		_document = sb.toString();
	}
}
