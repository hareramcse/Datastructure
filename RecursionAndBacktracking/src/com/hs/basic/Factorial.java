package com.hs.basic;

public class Factorial {
	public int fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * fact(n - 1);
	}

	public static void main(String[] args) {
		Factorial obj = new Factorial();
		int fact = obj.fact(3);
		System.out.println(fact);
	}
}
