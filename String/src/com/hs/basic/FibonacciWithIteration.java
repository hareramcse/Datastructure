package com.hs.basic;

public class FibonacciWithIteration {
	public void printSeries(int n) {
		int a = 0, b = 1;

		System.out.print("Upto " + n + ": ");
		while (a <= n) {
			System.out.print(a + " ");
			int sum = a + b;
			a = b;
			b = sum;
		}
	}

	public static void main(String[] args) {
		FibonacciWithIteration fi = new FibonacciWithIteration();
		fi.printSeries(5);
	}
}