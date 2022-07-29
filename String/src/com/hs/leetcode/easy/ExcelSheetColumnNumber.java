package com.hs.leetcode.easy;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String columnTitle) {
		int result = 0;
		for (char ch : columnTitle.toCharArray()) {
			int d = ch - 'A' + 1;
			result = result * 26 + d;
		}
		return result;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
		String columnTitle = "ZY";
		int result = obj.titleToNumber(columnTitle);
		System.out.println(result);
	}
}
