package com.hs.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParanthesis {
	public String minRemoveToMakeValid(String s) {
		if (s == null || s.isEmpty()) return s;
        
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of indices of unmatched '('
        Set<Integer> toRemove = new HashSet<>(); // Indices of invalid parentheses

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    toRemove.add(i); // Unmatched ')'
                } else {
                    stack.pop(); // Match found for '('
                }
            }
        }

        // Add remaining unmatched '(' indices to toRemove set
        while (!stack.isEmpty()) {
            toRemove.add(stack.pop());
        }

        // Second pass: Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
	}

	public static void main(String[] args) {
		MinimumRemoveToMakeValidParanthesis obj = new MinimumRemoveToMakeValidParanthesis();
		String s = "lee(t(c)o)de)";
		String result = obj.minRemoveToMakeValid(s);
		System.out.println(result);
	}
}