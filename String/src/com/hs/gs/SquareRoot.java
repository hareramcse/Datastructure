package com.hs.gs;

public class SquareRoot {

	public static double squareRoot(double x) {
		double threshold = 0.001;
		double guess = x / 2.0;
		for (int iterations = 500; iterations > 0 && Math.abs(guess * guess - x) > threshold; iterations--) {
			guess = guess - ((guess * guess - x) / (2.0 * guess));
		}

		return guess;
	}

	public static void main(String args[]) {
		double[] inputs = { 2, 4, 100 };
		double[] expected_values = { 1.41421, 2.1, 10 };
		double threshold = 0.001;
		for (int i = 0; i < inputs.length; i++) {
			if (Math.abs(squareRoot(inputs[i]) - expected_values[i]) > threshold) {
				System.out.printf("Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i],
						squareRoot(inputs[i]));
			}
		}
		System.out.println("All tests passed");
	}
}