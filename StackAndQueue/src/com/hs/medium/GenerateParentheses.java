package com.hs.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
	Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();
    
	public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator<Character> it = stack.iterator();
            String temp = "";
            while (it.hasNext()) {
                temp = temp + it.next();
            }
            res.add(temp);
        }
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }

	public static void main(String[] args) {
		GenerateParentheses obj = new GenerateParentheses();
		List<String> result = obj.generateParenthesis(3);
		System.out.println(result);
	}
}