package com.hs.gs;

public class Atoi {
	public static int atoi(String str) {
		int result = 0;
		int i = 0;
		int strLength = str.length();
		int multiplier = 1;

		if (strLength != 0 && str.charAt(0) == '-') {
			multiplier = -1;
			i++;
		}

		for (; i < strLength; i++) {
			char c = str.charAt(i);

			if (c < '0' || c > '9') {
				break;
			}

			result = result * 10 + c - '0';
		}

		return result * multiplier;
	};

	public static boolean doTestsPass() {
		boolean result = true;
		result = result && atoi("0") == 0;
		result = result && atoi("1") == 1;
		result = result && atoi("123") == 123;
		result = result && atoi("-1") == -1;
		result = result && atoi("-123") == -123;
		result = result && atoi("123a") == 123;
		result = result && atoi("a") == 0;

		String intMax = String.valueOf(Integer.MAX_VALUE);
		result = result && atoi(intMax) == Integer.MAX_VALUE;

		String intMin = String.valueOf(Integer.MIN_VALUE);
		result = result && atoi(intMin) == Integer.MIN_VALUE;

		return result;
	};

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}
	}
}
