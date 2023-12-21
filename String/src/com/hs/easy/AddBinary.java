package com.hs.easy;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		int alen = a.length();
		int blen = b.length();
		int carry = 0;
		int i = 0;
		while (i < alen || i < blen || carry != 0) {
			int x = 0;
			if (i < alen && a.charAt(alen - 1 - i) == '1')
				x = 1;

			int y = 0;
			if (i < blen && b.charAt(blen - 1 - i) == '1')
				y = 1;

			int value = x + y + carry;
			result.insert(0, value % 2);
			carry = value / 2;
			i++;
		}
		return result.toString();
	}

	public static void main(String[] args) {
		AddBinary obj = new AddBinary();
		String a = "1010";
		String b = "1011";
		String addBinary = obj.addBinary(a, b);
		System.out.println(addBinary);
	}
}