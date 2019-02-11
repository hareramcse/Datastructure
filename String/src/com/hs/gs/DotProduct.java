package com.hs.gs;

public class DotProduct {
	public static int dotProduct(int[] array1, int[] array2) throws IllegalArgumentException {

		// check boundary conditions
		// Null array
		// Empty array
		// Array length is equal

		int sum = 0;
		if (array1 == null || array2 == null) {
			throw new IllegalArgumentException("Null array . Invalid input");
		}

		for (int i = 0; i < array1.length; i++) {
			sum += array1[i] * array2[i];
		}

		System.out.println("Result of the dot product of array1 and array2 is : " + sum);
		return sum;

	}

	public static void main(String[] args) {

		int[] array1 = { 1, 2 };
		int[] array2 = { 2, 3 };
		int result = dotProduct(array1, array2);

		if (result == 8) {
			System.out.println("Passed.");
		} else {
			System.out.println("Failed.");
		}
	}
}
