package com.hs.array.orderstatistics;

public class KthLargestElement {

	// Standard partition process of QuickSort.
	// It considers the last element as pivot
	// and moves all smaller element to left of
	// it and greater elements to right
	public static int partition(Integer[] arr, int start, int end) {
		int pIndex = start;
		int pivot = arr[end];
		for (int i = start; i <= end - 1; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
		}
		int temp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end] = temp;

		return pIndex;
	}

	// This function returns k'th smallest element
	// in arr[l..r] using QuickSort based method.
	// ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
	public static int kthSmallest(Integer[] arr, int start, int end, int k) {
		// If k is smaller than number of elements
		// in array
		if (k > 0 && k <= end - start + 1) {
			// Partition the array around last
			// element and get position of pivot
			// element in sorted array
			int pIndex = partition(arr, start, end);

			// If position is same as k
			if (pIndex - start == k - 1)
				return arr[pIndex];

			// If position is more, recur for left subarray
			if (pIndex - start > k - 1)
				return kthSmallest(arr, start, pIndex - 1, k);

			// Else recur for right subarray
			return kthSmallest(arr, pIndex + 1, end, (k - 1) - (pIndex - start));
		}

		// If k is more than number of elements in array
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 12, 3, 5, 7, 4, 19, 26 };
		int k = 3;
		System.out.print("K'th smallest element is " + kthSmallest(arr, 0, arr.length - 1, k));
	}
}