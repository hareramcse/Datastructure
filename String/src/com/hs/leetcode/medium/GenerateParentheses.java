package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	List<String> result = new ArrayList<>(); 
    public List<String> generateParenthesis(int n) {
        int open = n;
        int closed = n;
        String output = "";
        generateParenthesisUtil(open, closed, output, n);
        return result;
    }
    
    private void generateParenthesisUtil(int open, int closed, String output, int n) {
		if (open == 0 && closed == 0) {
			result.add(output);
			return;
		}
		if (open != 0) {
			String op1 = output;
			op1 = op1 + "(";
			generateParenthesisUtil(open - 1, closed, op1, n);
		}
		if (closed > open) {
			String op2 = output;
			op2 = op2 + ")";
			generateParenthesisUtil(open, closed - 1, op2, n);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses pas = new GenerateParentheses();
		pas.generateParenthesis(3);
		System.out.println(pas.result);
	}
}