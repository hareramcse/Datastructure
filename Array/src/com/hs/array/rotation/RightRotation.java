package com.hs.array.rotation;

// 189. Rotate Array Leetcode
public class RightRotation {

	// Function to right rotate arr[] of size n by d
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int a = nums.length - k;
		reverseArray(nums, 0, a - 1);
		reverseArray(nums, a, n - 1);
		reverseArray(nums, 0, n - 1);
	}

	private void reverseArray(int arr[], int start, int end) {
		if (arr == null || arr.length == 1) {
			return;
		}

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

		array.rotate(arr, k);
		array.printArray(arr, n);

	}
}