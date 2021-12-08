package com.hs.misc;

public class FibonaciWithIteration {

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
		FibonaciWithIteration fi = new FibonaciWithIteration();
		fi.printSeries(5);
	}

}