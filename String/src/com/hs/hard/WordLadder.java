package com.hs.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		Map<String, Boolean> Vmap = new HashMap<String, Boolean>();
		for (int i = 0; i < wordList.size(); i++)
			Vmap.put(wordList.get(i), false);

		Queue<String> q = new LinkedList<String>();
		int length = 1;
		q.add(beginWord);
		Vmap.put(beginWord, true);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String w = q.poll();
				if (w.equals(endWord))
					return length;
				wordMatch(w, Vmap, q);
			}
			length++;
		}
		return 0;
	}

	public void wordMatch(String w, Map<String, Boolean> Vmap, Queue<String> q) {
		for (int i = 0; i < w.length(); i++) {
			char[] word = w.toCharArray();
			for (int j = 0; j < 26; j++) {
				char c = (char) ('a' + j);
				word[i] = c;
				String s = String.valueOf(word);
				if (Vmap.containsKey(s) && Vmap.get(s) == false) {
					q.add(s);
					Vmap.put(s, true);
				}
			}
		}
	}

	public static void main(String[] args) {
		WordLadder obj = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> list = Arrays.asList(wordList);
		int result = obj.ladderLength(beginWord, endWord, list);
		System.out.println(result);
	}
}