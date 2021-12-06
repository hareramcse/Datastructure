package com.hs.array.rotation;

public class LeftRotate {

	// Fills temp[] with two copies of arr[]
	private void preProcess(int arr[], int n, int temp[]) {
		// Store arr[] elements at i and i + n
		for (int i = 0; i < n; i++) {
			temp[i + n] = arr[i];
			temp[i] = temp[i + n];
		}
	}

	// Function to left rotate an array k time
	private void leftRotate(int arr[], int n, int k, int temp[]) {
		// Starting position of array after k
		// rotations in temp[] will be k % n
		int start = k % n;

		// Print array after k rotations
		for (int i = start; i < start + n; i++)
			System.out.print(temp[i] + " ");

		System.out.print("\n");
	}

	// Driver program
	public static void main(String[] args) {
		LeftRotate array = new LeftRotate();
		int arr[] = { 1, 3, 5, 7, 9 };
		int n = arr.length;

		int temp[] = new int[2 * n];
		array.preProcess(arr, n, temp);

		int k = 2;
		array.leftRotate(arr, n, k, temp);
	}
}