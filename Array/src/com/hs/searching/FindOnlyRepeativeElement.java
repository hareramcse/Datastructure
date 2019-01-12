package com.hs.searching;

class FindOnlyRepeativeElement {

	static int findRepeating(int arr[], int n) {

		// res is going to store value of
		// 1 ^ 2 ^ 3 .. ^ (n-1) ^ arr[0] ^
		// arr[1] ^ .... arr[n-1]
		int res = 0;
		for (int i = 0; i < n - 1; i++)
			res = res ^ (i + 1) ^ arr[i];
		res = res ^ arr[n - 1];

		return res;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 9, 8, 2, 6, 1, 8, 5, 3, 4, 7 };
		int n = arr.length;
		System.out.println(findRepeating(arr, n));
	}
}
