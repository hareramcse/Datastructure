package com.hs.leetcode;

// 8. String to Integer (atoi) Leetcode
public class StringToIntegerAtoi {
	public int myAtoi(String s) {
		if (s.isEmpty()) {
			return 0;
		}

		int sign = 1, i = 0, n = s.length();
		
		// move till we dont get char
		while (i < n && s.charAt(i) == ' ') {
			i++;
		}
		
		// if whole string is white space only
		if (i >= n)
			return 0;

		// find the sign and get the index of the 1st digit
		if (s.charAt(i) == '+' || s.charAt(i) == '-') {
			sign = s.charAt(i) == '+' ? 1 : -1;
			i++;
		}

		long res = 0;
		while (i < n && Character.isDigit(s.charAt(i))) {
			res = res * 10 + (s.charAt(i) - '0');
			i++;
			if (res * sign > Integer.MAX_VALUE || res * sign < Integer.MIN_VALUE) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
		}

		return (int) res * sign;
	}

	public static void main(String[] args) {
		StringToIntegerAtoi obj = new StringToIntegerAtoi();
		String str = " -123";
		int myAtoi = obj.myAtoi(str);
		System.out.println(myAtoi);
	}
}