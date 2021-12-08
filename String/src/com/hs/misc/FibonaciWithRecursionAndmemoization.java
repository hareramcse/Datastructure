package com.hs.misc;

public class FibonaciWithRecursionAndmemoization {

	public static int fibArray[] = new int[31];

	public static int fibonacci(int n) {
		int fibValue = 0;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (fibArray[n] != 0) {
			return fibArray[n];
		} else {
			fibValue = fibonacci(n - 1) + fibonacci(n - 2);
			fibArray[n] = fibValue;
			return fibValue;
		}
	}

	public static void main(String args[]) {
		fibArray[0] = 1;
		fibArray[1] = 1;
		long preTime = System.currentTimeMillis();
		System.out.println("Value of 25th number in Fibonacci series->" + fibonacci(30));
		long postTime = System.currentTimeMillis();
		System.out.println("Time taken to compute in milliseconds->" + (postTime - preTime));
	}

}