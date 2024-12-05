package com.hs.medium;

import java.util.Stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		int length = num.length();
		if (k == length)
			return "0";

		Stack<Character> stack = new Stack<>();
		for (char ch : num.toCharArray()) {
			while (!stack.isEmpty() && ch < stack.peek() && k > 0) { // create decreasing monotonic seq
				stack.pop();
				k--;
			}
			stack.push(ch);
		}

		// if input is in increasing order in that case stack will already be in
		// decreasing monotonic seq, in that case k will remain k as we could not delete
		// any number to make decreasing monotonic seq
		while (!stack.isEmpty() && k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder ans = new StringBuilder();
		for (char ch : stack) { // this way no need to reverse the ans
			ans.append(ch);
		}

		// to handle the leading 0 at starting of the input
		while (ans.length() > 1 & ans.charAt(0) == '0') {
			ans.deleteCharAt(0);
		}

		return ans.toString();
	}

	public static void main(String[] args) {
		RemoveKDigits obj = new RemoveKDigits();
		String num = "1432219";
		int k = 3;
		String result = obj.removeKdigits(num, k);
		System.out.println(result);
	}
}