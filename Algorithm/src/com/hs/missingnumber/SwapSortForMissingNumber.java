package com.hs.missingnumber;

public class SwapSortForMissingNumber {
	private void solve(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] != arr[arr[i] - 1]) {
				swap(arr, i, arr[i] - 1);
			} else {
				i++;
			}
		}

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != j + 1) {
				System.out.println("Missing number is " + (j + 1));
				System.out.println("Duplicate number is " + arr[j]);
			}
		}
	}

	private void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

	public static void main(String[] args) {
		SwapSortForMissingNumber ssfmn = new SwapSortForMissingNumber();
		int[] arr = { 1, 3, 5, 5, 7, 4, 8, 3 };
		ssfmn.solve(arr);
	}

}
