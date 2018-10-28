package com.hs.searching;

public class LinearSearch {
	private boolean search(int arr[], int value) {
		boolean found = false;
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			if (arr[i] == value) {
				found = true;
			}
		}
		if (found == true) {
			System.out.println("value found");
		} else {
			System.out.println("value not found");
			found = false;
		}
		return found;
	}

	public static void main(String[] args) {
		int arr[] = { 12, 23, 4, 25, 2, 22, 15, 65 };
		LinearSearch search = new LinearSearch();
		boolean found = search.search(arr, 211);
		System.out.println("value found ? " + found);
	}
}
