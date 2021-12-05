package com.hs.array.rotation;

public class FindPairSumInSortedRotatedArray {

	private boolean findSum(int arr[], int value) {
		int n = arr.length;
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
		FindPairSumInSortedRotatedArray array = new FindPairSumInSortedRotatedArray();
		int arr[] = { 11, 15, 6, 8, 9, 10 };
		int sum = 17;

		boolean found = array.findSum(arr, sum);
		System.out.println(found);

	}
}
