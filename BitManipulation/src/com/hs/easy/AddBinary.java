package com.hs.easy;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;

		int carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) {
				sum += a.charAt(i--) - '0';
			}

			if (j >= 0) {
				sum += b.charAt(j--) - '0';
			}

			sb.insert(0, sum % 2);
			carry = sum / 2;
		}
		
		if(carry > 0)
			sb.insert(0, 1);

		return sb.toString();
	}

	public static void main(String[] args) {
		AddBinary obj = new AddBinary();
		String a = "1010";
		String b = "1011";
		String addBinary = obj.addBinary(a, b);
		System.out.println(addBinary);
	}
}
