package com.hs.array.rotation;

public class SearchElement {
	public static void search(int arr[], int key, int low, int high) {
		int mid = (low + high) / 2;
		if (low > high) {
			return;
		} else {
			if (arr[mid] == key) {
				System.out.println(mid);
				System.exit(0);
			} else {
				search(arr, key, mid - 1, high);
				search(arr, key, low, mid + 1);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int key = 1;
		int low = 0;
		int high = arr.length - 1;
		search(arr, key, low, high);
	}
}
