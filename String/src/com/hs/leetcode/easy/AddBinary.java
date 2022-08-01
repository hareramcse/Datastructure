package com.hs.leetcode.easy;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder ans = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;

		int carry = 0;
		while (i >= 0 || j >= 0) {
			int digit1 = i >= 0 ? a.charAt(i) - '0' : 0;
			int digit2 = j >= 0 ? b.charAt(j) - '0' : 0;
			int sum = digit1 + digit2 + carry;
			carry = sum / 2;
			sum = sum % 2;
            ans.append(sum);
			i--;
			j--;
		}

		if (carry > 0)
            ans.append(carry);

		return ans.reverse().toString();
	}

	public static void main(String[] args) {
		AddBinary obj = new AddBinary();
		String a = "1010";
		String b = "1011";
		String addBinary = obj.addBinary(a, b);
		System.out.println(addBinary);
	}
}