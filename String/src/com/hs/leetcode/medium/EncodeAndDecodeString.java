package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeString {
	final char DELIMITER = '#';

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str.length());
			sb.append(DELIMITER);
			sb.append(str);
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String str) {
		List<String> res = new LinkedList<>();
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// Find the number of characters
			StringBuilder sb = new StringBuilder();
			while (arr[i] != DELIMITER) {
				sb.append(arr[i++]);
			}
			i++;

			// Iteration the enter string to add to res list
			int numOfChars = Integer.valueOf(sb.toString());
			int end = i + numOfChars;
			sb = new StringBuilder();
			while (i < end) {
				sb.append(arr[i++]);
			}
			i--;
			res.add(sb.toString());
		}
		return res;
	}

	public static void main(String[] args) {
		EncodeAndDecodeString obj = new EncodeAndDecodeString();
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("How");
		list.add("are");
		list.add("you");
		String encodedString = obj.encode(list);
		List<String> decodeString = obj.decode(encodedString);
		System.out.println(decodeString);
	}
}
