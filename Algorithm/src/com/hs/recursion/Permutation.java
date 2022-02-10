package com.hs.recursion;

public class Permutation {
	private void permutationFind(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		String op1 = output;
		String op2 = output;
		op2 += input.charAt(0);
		input = input.substring(1);

		permutationFind(input, op1);
		permutationFind(input, op2);
	}

	public static void main(String[] args) {
		Permutation perm = new Permutation();
		String ip = "abc";
		String op = "";
		perm.permutationFind(ip, op);
	}
}
