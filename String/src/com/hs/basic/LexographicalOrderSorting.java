package com.hs.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexographicalOrderSorting {
	public static void main(String[] args) {
		String s = "example string";
		List<String> list = new ArrayList<>();
		for (int i = 0; i <= s.length() - 3; i++) {
			String substr = s.substring(i, i + 3);
			if (substr.matches("[a-zA-Z]+")) {
				System.out.println(substr);
				list.add(substr);
			}
		}

		Collections.sort(list);
		System.out.println("min and max string are : ");
		System.out.println(list.get(0));
		System.out.println(list.get(list.size() - 1));
	}
}
