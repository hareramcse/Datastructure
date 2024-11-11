package com.hs.leetcode.hard;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(beginWord, 1));
		Set<String> set = new HashSet<>(wordList);
		set.remove(beginWord);

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			String word = pair.first;
			int steps = pair.second;

			// we return the steps as soon as the first occurrence of targetWord is found.
			if (word.equals(endWord) == true)
				return steps;

			// Now, replace each character of ‘word’ with char from a-z then check if ‘word’
			// exists in wordList.
			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char replacedCharArray[] = word.toCharArray();
					replacedCharArray[i] = ch;
					String replacedWord = new String(replacedCharArray);

					// check if it exists in the set and push it in the queue.
					if (set.contains(replacedWord) == true) {
						set.remove(replacedWord);
						queue.add(new Pair(replacedWord, steps + 1));
					}
				}

			}
		}

		// If there is no transformation sequence possible
		return 0;
	}

	public static void main(String[] args) throws IOException {
		WordLadder1 obj = new WordLadder1();
		String startWord = "der", targetWord = "dfs";
		String[] words = { "des", "der", "dfr", "dgt", "dfs" };
		List<String> wordList = Arrays.asList(words);
		int ans = obj.ladderLength(startWord, targetWord, wordList);
		System.out.print(ans);
	}
}