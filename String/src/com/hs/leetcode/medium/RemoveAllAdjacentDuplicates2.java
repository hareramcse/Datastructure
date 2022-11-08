package com.hs.leetcode.medium;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates2 {
	public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        
		for (char ch : s.toCharArray()) {
			if (!stack.isEmpty() && (stack.peek().key == ch)) {
				Pair pair = stack.pop();
				pair.value++;
				stack.push(pair);
				if (stack.peek().value == k) {
					stack.pop();
				}
			} else {
				Pair pair = new Pair(ch, 1);
				stack.push(pair);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			int count = pair.value;
			while (count != 0) {
				sb.append(pair.key);
				count--;
			}
		}
		return sb.reverse().toString();
    }

	public static void main(String[] args) {
		RemoveAllAdjacentDuplicates2 obj = new RemoveAllAdjacentDuplicates2();
		String s = "deeedbbcccbdaa";
		int k = 3;
		String result = obj.removeDuplicates(s, k);
		System.out.println(result);
	}
}