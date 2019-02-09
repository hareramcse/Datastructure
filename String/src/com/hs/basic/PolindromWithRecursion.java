package com.hs.basic;

public class PolindromWithRecursion {

	private String reverseString(String str) {
		if (str == null) {
			return null;
		}
		if (str.length() <= 1) {
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);
	}

	private void reverse(String str) {
		int start = 0;
		int end = str.length() - 1;
		int mid = (start + end) / 2;

		while (start <= mid) {
			if (str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			} else {
				break;
			}
		}

		if (start == mid + 1) {
			System.out.println(str + " is a polindrom");
		} else {
			System.out.println(str + " is not a polindrom");
		}
	}

	public static void main(String[] args) {
		String str = "abdddda";
		PolindromWithRecursion pwr = new PolindromWithRecursion();
		String reversedString = pwr.reverseString(str);
		if (reversedString.equals(str)) {
			System.out.println(str + " is a polindrom");
		} else {
			System.out.println(str + " is not a polindrom");
		}

		pwr.reverse("abba");
	}
}
