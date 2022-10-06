package com.hs.gfg.easy;

public class PrintAllDivisor {
	public void printDivisorsOptimal(int n) {
		System.out.println("The divisors of " + n + " are:");
		for (int i = 1; i <= (int) Math.sqrt(n); i++)
			if (n % i == 0) {
				System.out.print(i + " ");
				if (i != n / i)
					System.out.print(n / i + " ");
			}
		System.out.println();
	}

	public static void main(String[] args) {
		PrintAllDivisor obj = new PrintAllDivisor();
		int n = 36;
		obj.printDivisorsOptimal(n);
	}
}
