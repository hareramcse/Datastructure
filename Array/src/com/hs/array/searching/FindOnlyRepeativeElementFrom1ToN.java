package com.hs.array.searching;

class FindOnlyRepeativeElementFrom1ToN {

	private int findRepeating(int arr[]) {
		int n = arr.length;
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
		FindOnlyRepeativeElementFrom1ToN array = new FindOnlyRepeativeElementFrom1ToN();
		int arr[] = { 5, 4, 3, 9, 8, 9, 1, 6, 2, 5 };
		System.out.println(array.findRepeating(arr));
	}
}