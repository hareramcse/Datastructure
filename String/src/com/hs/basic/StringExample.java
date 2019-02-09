package com.hs.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringExample {
	static int[] matchingStrings(String[] strings, String[] queries) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : strings) {
			Integer count = map.get(str);
			if (count == null) {
				map.put(str, 1);
			} else {
				map.put(str, count + 1);
			}
		}
		int[] arr = new int[queries.length];
		int k=0;
		for (int i = 0; i < queries.length; i++) {
			Integer j = map.get(queries[i]);
			if (j == null)
				j = 0;
			arr[k++] = j;
		}
		return arr;

	}

	public static void main(String[] args) {
		String s2[] = { "abc", "def", "ghi", "jkl", "abc", "def", "kls", "nmk", "abc" };
		String[] s3 = { "abc", "def", "ghi", "ffg" };

		int[] arr = matchingStrings(s2, s3);
		System.out.println(Arrays.toString(arr));
	}

}
