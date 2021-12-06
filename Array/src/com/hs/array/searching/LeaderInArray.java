package com.hs.array.searching;

/*
 * An element is leader if it is greater than all the elements to its right side. 
 * And the rightmost element is always a leader.
 * */
public class LeaderInArray {

	private void printLeaders(int arr[], int n) {
		int max_from_right = arr[n - 1];

		/* Rightmost element is always leader */
		System.out.print(max_from_right + " ");

		for (int i = n - 2; i >= 0; i--) {
			if (max_from_right < arr[i]) {
				max_from_right = arr[i];
				System.out.print(max_from_right + " ");
			}
		}
	}

	public static void main(String[] args) {
		LeaderInArray array = new LeaderInArray();
		int arr[] = new int[] { 16, 17, 4, 3, 5, 2 };
		int n = arr.length;
		array.printLeaders(arr, n);
	}
}
