package com.hs.easy;

public class PairsWithSumK {

	private int findCount(int arr[], int value) {
		int n = arr.length;
		int i;
		for (i = 0; i < n; i++) {
			if (arr[i] > arr[i + 1]) {
				break;
			}
		}

		int min = i + 1;
		int max = i;
		
		int ans = 0;
		while (min != max) {
			if (arr[min] + arr[max] == value) {
				ans++;
			}
			if (arr[min] + arr[max] > value) {
				max = (max - 1 + n) % n;
			} else {
				min = (min + 1) % n;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		PairsWithSumK obj = new PairsWithSumK();
		int arr[] = { 11, 15, 6, 7, 9, 10 };
		int sum = 17;

		int result = obj.findCount(arr, sum);
		System.out.println(result);
	}
}