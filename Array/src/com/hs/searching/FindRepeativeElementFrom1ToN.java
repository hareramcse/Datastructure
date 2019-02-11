package com.hs.searching;

class FindRepeativeElementFrom1ToN {

	static int findRepeating(int arr[], int n) {
		int missingElement = 0;

		// indexing based
		for (int i = 0; i < n; i++) {
			int element = arr[Math.abs(arr[i])];
			if (element < 0) {
				missingElement = arr[i];
				break;
			}
			arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
		}
		return Math.abs(missingElement);
	}

	public static void main(String[] args) {
		int arr[] = { 5, 4, 3, 9, 8, 9, 1, 6, 2, 5 };
		int n = arr.length;
		System.out.println(findRepeating(arr, n));
	}
}