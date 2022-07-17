package com.hs.leetcode;

// 443. String Compression Leetcode Medium
public class StringCompression {
	public int compress(char[] chars) {
		int index = 0;
		int i = 0;
		while (i < chars.length) {
			int j = i;
			while (j < chars.length && chars[i] == chars[j]) {
				j++;
			}

			chars[index++] = chars[i];
			if (j - i > 1) {
				String count = j - i + "";
				for (char ch : count.toCharArray()) {
					chars[index++] = ch;
				}
			}

			i = j;
		}
		return index;
	}

	public static void main(String[] args) {
		StringCompression obj = new StringCompression();
		char[] input = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		int compress = obj.compress(input);
		System.out.println(compress);
	}
}