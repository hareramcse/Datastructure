package com.hs.array.rotation;

public class ThreeSortedCircularArraySearch {
	private int search(int arr[], int value) {
		int lenght = arr.length;
		int low = 0, high = lenght - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (value == arr[mid]) {
				return mid;
			} else if (arr[mid] <= arr[high]) {// right half is sorted
				if (value > arr[mid] && value <= arr[high]) {
					low = mid + 1; // searching in right sorted half
				} else {
					high = mid - 1; // searching in left
				}
			} else { // left half is sorted
				// searching in left sorted half
				if (value < arr[mid] && value >= arr[low]) {
					high = mid - 1; // searching in left
				} else {
					low = mid + 1; // searching in right
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 12, 34, 45, 55, 65, 2, 4, 5, 7, 9, 10 };
		ThreeSortedCircularArraySearch search = new ThreeSortedCircularArraySearch();
		int index = search.search(arr, 45);
		System.out.println("value found at index " + index);
	}
}
