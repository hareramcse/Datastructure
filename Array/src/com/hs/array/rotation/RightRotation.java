package com.hs.array.rotation;

public class RightRotation {

	// Function to right rotate arr[] of size n by d
	private void rightRotate(int arr[], int d, int n) {
		reverseArray(arr, 0, n - 1);
		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, n - 1);
	}

	// Function to reverse arr[] from index start to end
	private void reverseArray(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	// Function to print an array
	private void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		RightRotation array = new RightRotation();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int n = arr.length;
		int k = 3;

		array.rightRotate(arr, k, n);
		array.printArray(arr, n);

	}
}