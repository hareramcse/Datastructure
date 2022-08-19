package com.hs.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < wordList.size(); i++)
			map.put(wordList.get(i), false);

		Queue<String> q = new LinkedList<String>();
		int length = 1;
		q.add(beginWord);
		map.put(beginWord, true);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String w = q.poll();
				if (w.equals(endWord))
					return length;
				wordMatch(w, map, q);
			}
			length++;
		}
		return 0;
	}

	public void wordMatch(String w, Map<String, Boolean> map, Queue<String> q) {
		for (int i = 0; i < w.length(); i++) {
			char[] word = w.toCharArray();
			for (int j = 0; j < 26; j++) {
				char c = (char) ('a' + j);
				word[i] = c;
				String s = String.valueOf(word);
				if (map.containsKey(s) && map.get(s) == false) {
					q.add(s);
					map.put(s, true);
				}
			}
		}
	}
}