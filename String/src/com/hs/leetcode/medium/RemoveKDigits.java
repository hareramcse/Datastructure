package com.hs.leetcode.medium;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		int digits = num.length() - k;
		if (num.length() <= k)
			return "0";

		int top = -1, start = 0;
		char[] st = num.toCharArray();
		for (int i = 0; i < st.length; i++) {
			while (top >= 0 && st[top] > st[i] && k > 0) {
				top--;
				k--;
			}
			top++;
			st[top] = st[i];
		}

		while (start <= top && st[start] == '0')
			k++;

		String ans = "";
		for (int i = start; i < digits; i++)
			ans = ans + st[i];

		if (ans.equals(""))
			return "0";

		return ans;
	}

	public static void main(String[] args) {
		RemoveKDigits obj = new RemoveKDigits();
		String num = "1432219";
		int k = 3;
		String result = obj.removeKdigits(num, k);
		System.out.println(result);
	}
}