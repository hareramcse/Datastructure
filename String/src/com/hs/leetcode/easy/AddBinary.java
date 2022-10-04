package com.hs.leetcode.easy;

public class AddBinary {
	public String addBinary(String a, String b) {
		int carry = 0;
		String result = "";
		int i = 0;
		int alen = a.length();
		int blen = b.length();
		while (i < alen || i < blen || carry != 0) {
			int x = 0;
			if (i < alen && a.charAt(alen - 1 - i) == '1')
				x = 1;
			int y = 0;
			if (i < blen && b.charAt(blen - 1 - i) == '1')
				y = 1;

			result = (x + y + carry) % 2 + result;
			carry = (x + y + carry) / 2;
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		AddBinary obj = new AddBinary();
		String a = "1010";
		String b = "1011";
		String addBinary = obj.addBinary(a, b);
		System.out.println(addBinary);
	}
}