package com.hs.gfg.easy;

public class FindSecondLargestNumber {

	private int secondLargest(int arr[], int arr_size) {
		if (arr.length < 2)
			return -1;

		int large = Integer.MIN_VALUE;
		int second_large = Integer.MIN_VALUE;
		int i;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] > large) {
				second_large = large;
				large = arr[i];
			}

			else if (arr[i] > second_large && arr[i] != large) {
				second_large = arr[i];
			}
		}
		return second_large;
	}

	public static void main(String[] args) {
		FindSecondLargestNumber obj = new FindSecondLargestNumber();
		int arr[] = { 12, 35, 1, 10 };
		int n = arr.length;
		int result = obj.secondLargest(arr, n);
		System.out.println(result);
	}
}