package com.hs.basic;

public class SumOfDiagonal {
	public static void main(String[] args) {
		int sum1 = 0;
		int sum2 = 0;

		int arr[][] = { { 1, 2, 5 }, { 6, 7, 8 }, { 11, 12, 13 } };
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					sum1 += arr[i][j];
				}
				if (i + j == (n - 1)) {
					sum2 += arr[i][j];
				}
			}
		}

		System.out.println(sum1);
		System.out.println(sum2);
	}
}
