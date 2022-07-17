package com.hs.leetcode;

// 8. String to Integer (atoi) Leetcode
public class StringToIntegerAtoi {
	public int myAtoi(String s) {
		s = s.trim();
		if (s == null || s.length() == 0) {
			return 0;
		}
		double result = 0;

		// check for positive or negative sign
		boolean isNegative = false;
		int startIndex = 0;

		if (s.charAt(0) == '+' || s.charAt(0) == '-') {
			++startIndex;
		}

		if (s.charAt(0) == '-') {
			isNegative = true;
		}

		// handle numeric case = "123"
		for (int i = startIndex; i < s.length(); i++) {
			// handle for non numeric characters
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				break;
			}
			int digitValue = (int) (s.charAt(i) - '0');
			result = result * 10 + digitValue;
		}

		// toggle result in case of negative is true
		if (isNegative) {
			result = -result;
		}

		// handle underflow
		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		// handle overflow
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		// return result
		return (int) result;
	}

	public static void main(String[] args) {
		StringToIntegerAtoi obj = new StringToIntegerAtoi();
		String str = " -123";
		int myAtoi = obj.myAtoi(str);
		System.out.println(myAtoi);
	}
}
