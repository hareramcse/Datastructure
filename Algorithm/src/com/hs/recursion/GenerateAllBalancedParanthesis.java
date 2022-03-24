package com.hs.recursion;

public class GenerateAllBalancedParanthesis {
	private void generateAllBalancedParanthesis(int open, int closed, String op, int n) {
		if (open == 0 && closed == 0) {
			System.out.println(op);
			return;
		}
		if (open != 0) {
			String op1 = op;
			op1 = op1 + "(";
			generateAllBalancedParanthesis(open - 1, closed, op1, n);
		}
		if (closed > open) {
			String op2 = op;
			op2 = op2 + ")";
			generateAllBalancedParanthesis(open, closed - 1, op2, n);
		}
	}

	public static void main(String[] args) {
		GenerateAllBalancedParanthesis pas = new GenerateAllBalancedParanthesis();
		int n = 3;
		int open = n;
		int closed = n;
		String op = "";
		pas.generateAllBalancedParanthesis(open, closed, op, n);
	}
}
