package com.hs.basic;

public class PrintNameNTimes {
	public void printNtimes(int i, int n) {
		if (i > n)
			return;
		System.out.println(i);
		printNtimes(i + 1, n);
	}

	public static void main(String[] args) {
		PrintNameNTimes obj = new PrintNameNTimes();
		int i = 1;
		int n = 3;
		obj.printNtimes(i, n);
	}
}
