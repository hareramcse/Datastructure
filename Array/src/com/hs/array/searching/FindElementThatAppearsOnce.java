package com.hs.array.searching;

class FindElementThatAppearsOnce {

	static int findSingle(int arr[], int n) {
		// Do XOR of all elements and return
		int res = arr[0];
		for (int i = 1; i < n; i++)
			res = res ^ arr[i];

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 4, 5, 3, 4 };
		int n = arr.length;
		System.out.println("Element occurring once is " + findSingle(arr, n) + " ");
	}
}