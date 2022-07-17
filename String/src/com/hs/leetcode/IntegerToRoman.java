package com.hs.leetcode;

// 12. Integer to Roman Leetcode
public class IntegerToRoman {
	private String integerToRoman(int num) {
		String[] thousands = { "", "M", "MM", "MMM" };
		String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };

		String thousand = thousands[num / 1000];
		String hundred = hundreds[(num % 1000) / 100];
		String ten = tens[(num % 100) / 10];
		String unit = units[(num % 10)];

		return thousand + hundred + ten + unit;
	}

	public static void main(String[] args) {
		IntegerToRoman obj = new IntegerToRoman();
		int nums = 100;
		String integerToRoman = obj.integerToRoman(nums);
		System.out.println(integerToRoman);
	}
}
