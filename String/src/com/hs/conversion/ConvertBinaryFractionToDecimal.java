package com.hs.conversion;

public class ConvertBinaryFractionToDecimal {

	// Function to convert binary fractional to
	// decimal
	static double binaryToDecimal(String binary, int len) {

		// Fetch the radix point
		int point = binary.indexOf('.');

		// Update point if not found
		if (point == -1)
			point = len;

		double intDecimal = 0, fracDecimal = 0, twos = 1;

		// Convert integral part of binary to decimal
		// equivalent
		for (int i = point - 1; i >= 0; i--) {
			intDecimal += (binary.charAt(i) - '0') * twos;
			twos *= 2;
		}

		// Convert fractional part of binary to
		// decimal equivalent
		twos = 2;
		for (int i = point + 1; i < len; i++) {
			fracDecimal += (binary.charAt(i) - '0') / twos;
			twos *= 2.0;
		}

		// Add both integral and fractional part
		return intDecimal + fracDecimal;
	}

	// Driver Code
	public static void main(String[] args) {
		String n = "110.101";
		System.out.println(binaryToDecimal(n, n.length()));

		n = "101.1101";
		System.out.println(binaryToDecimal(n, n.length()));
	}

}