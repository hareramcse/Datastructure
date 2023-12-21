package com.hs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeString {
	char DELIMITER = '#';

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
		int no = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				no = no * 10 + (ch - '0');
			} else if (ch == '#') {
				String subString = str.substring(i + 1, no + i + 1);
				res.add(subString);
				no = 0;
			}
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
		System.out.println("Encoded String: " + encodedString);
		List<String> decodeString = obj.decode(encodedString);
		System.out.println("Decoded String" + decodeString);
	}
}
