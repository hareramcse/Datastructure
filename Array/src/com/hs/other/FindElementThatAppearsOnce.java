package com.hs.other;

class FindElementThatAppearsOnce {

	private int findSingle(int arr[]) {
		int n = arr.length;
		// Do XOR of all elements and return
		int res = arr[0];
		for (int i = 1; i < n; i++)
			res = res ^ arr[i];

		return res;
	}

	public static void main(String[] args) {
		FindElementThatAppearsOnce array = new FindElementThatAppearsOnce();
		int arr[] = { 2, 3, 5, 4, 5, 3, 4 };
		System.out.println("Element occurring once is " + array.findSingle(arr) + " ");
	}
}