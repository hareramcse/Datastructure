package com.hs.basic;

public class Fibonacci {
	public int fibonacci(int n) {
		if (n <= 1)
			return n;
		int last = fibonacci(n - 1);
		int sLast = fibonacci(n - 2);
		return last + sLast;
	}

	public static void main(String[] args) {
		Fibonacci obj = new Fibonacci();
		int n = 4;
		int result = obj.fibonacci(n);
		System.out.println(result);
	}
}
