package com.hs.misc;

public class FactorialWithIteration {

	public int printSeries(int n) {
		int x = 1;
		for (int i = 1; i <= n; i++) {
			x = x * i;
		}
		System.out.println(x);
		return x;
	}

	public static void main(String[] args) {
		FactorialWithIteration fi = new FactorialWithIteration();
		fi.printSeries(5);
	}

}