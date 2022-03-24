package com.hs.recursion;

public class LetterCasePermutation {
	private void letterCasePermutation(String ip, String op) {
		if (ip.length() == 0) {
			System.out.println(op);
			return;
		}
		if (Character.isLetter(ip.charAt(0))) {
			String op1 = op;
			String op2 = op;

			op1 = op1 + Character.toLowerCase(ip.charAt(0));
			op2 = op2 + Character.toUpperCase(ip.charAt(0));
			ip = ip.substring(1);
			letterCasePermutation(ip, op1);
			letterCasePermutation(ip, op2);
		} else {
			String op1 = op;
			op1 = op1 + ip.charAt(0);
			ip = ip.substring(1);
			letterCasePermutation(ip, op1);
		}
	}

	public static void main(String[] args) {
		String ip = "aB1cD";
		String op = "";
		LetterCasePermutation pas = new LetterCasePermutation();
		pas.letterCasePermutation(ip, op);
	}
}
