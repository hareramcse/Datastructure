package com.hs.array.rotation;

public class FourFindPairSumInSortedRotatedArray {

	private static boolean findSum(int arr[], int value, int n) {
		int i;
		for (i = 0; i < n; i++) {
			if (arr[i] > arr[i + 1]) {
				break;
			}
		}

		int min = i + 1;
		int max = i;

		while (min != max) {
			if (arr[min] + arr[max] == value) {
				return true;
			}
			if (arr[min] + arr[max] > value) {
				max = (max - 1 + n) % n;
			} else {
				min = (min + 1) % n;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 11, 15, 6, 8, 9, 10 };
		int sum = 17;
		int n = arr.length;

		boolean b2 = findSum(arr, sum, n);
		System.out.println(b2);

	}
}
