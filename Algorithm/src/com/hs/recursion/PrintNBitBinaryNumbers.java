package com.hs.recursion;

public class PrintNBitBinaryNumbers {
	private void printNBitBinaryNubers(int ones, int zeros, String op, int n) {
		if (n == 0) {
			System.out.println(op);
			return;
		}

		String op1 = op;
		op1 = op1 + "1";
		printNBitBinaryNubers(ones + 1, zeros, op1, n - 1);

		if (ones > zeros) {
			String op2 = op;
			op2 = op2 + "0";
			printNBitBinaryNubers(ones, zeros + 1, op2, n - 1);
		}
	}

	public static void main(String[] args) {
		PrintNBitBinaryNumbers pnbn = new PrintNBitBinaryNumbers();
		int n = 3;
		int ones = 0;
		int zeros = 0;
		String op = "";
		pnbn.printNBitBinaryNubers(ones, zeros, op, n);
	}
}
