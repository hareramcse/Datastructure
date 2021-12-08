package com.hs.arithmaticoperation;

public class SmallestNuberSuchThatItsSumIsNAndDivisibleBy10PowN {

	static void digitsNum(int N) {
		// If N = 0 the string will be 0
		if (N == 0)
			System.out.println("0");

		// If n is not perfectly divisible
		// by 9 output the remainder
		if (N % 9 != 0)
			System.out.print((N % 9));

		// Print 9 N/9 times
		for (int i = 1; i <= (N / 9); ++i)
			System.out.print("9");

		// Append N zero's to the number so
		// as to make it divisible by 10^N
		for (int i = 1; i <= N; ++i)
			System.out.print("0");
		System.out.print("");

	}

	// Driver Code
	public static void main(String[] args) {
		int N = 5;
		System.out.print("The number is : ");
		digitsNum(N);
	}

}