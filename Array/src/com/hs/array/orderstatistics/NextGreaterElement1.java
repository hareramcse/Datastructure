package com.hs.array.orderstatistics;

public class NextGreaterElement1 {

	// prints element and NGE pair for all elements of arr[] of size n
	private void printNGE(int arr[], int n) {
		int next, i, j;
		for (i = 0; i < n; i++) {
			next = -1;
			for (j = i + 1; j < n; j++) {
				if (arr[i] < arr[j]) {
					next = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + " -- " + next);
		}
	}

	public static void main(String args[]) {
		NextGreaterElement1 array = new NextGreaterElement1();
		int arr[] = { 11, 13, 21, 3 };
		int n = arr.length;
		array.printNGE(arr, n);
	}
}
