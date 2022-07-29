package com.hs.other;

public class PermutationWithSpaces {
	public void permuationWithSpaces(String ip, String op) {
		op = op + ip.charAt(0);
		ip = ip.substring(1);
		solve(ip, op);
	}

	private void solve(String ip, String op) {
		if (ip.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;

		op1 = op1 + "-";
		op1 = op1 + ip.substring(0, 1);
		op2 = op2 + ip.substring(0, 1);
		ip = ip.substring(1);
		solve(ip, op1);
		solve(ip, op2);
	}

	public static void main(String[] args) {
		String ip = "abc";
		String op = "";
		PermutationWithSpaces pas = new PermutationWithSpaces();
		pas.permuationWithSpaces(ip, op);
	}
}