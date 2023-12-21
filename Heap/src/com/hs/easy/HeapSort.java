package com.hs.easy;

import java.util.Arrays;

public class HeapSort {

	private int heapSize;

	private void buildMaxHeap(int arr[]) {
		// heap size initialized
		heapSize = arr.length;

		// since n/2, n/2+1 ... are leaf nodes, so we start from longest non
		// leaf node to root node
		for (int longestNonLeafIndex = arr.length / 2; longestNonLeafIndex >= 0; longestNonLeafIndex--) {
			// call MAX_HEAPIFY on each root node starting from n/2
			maxHeapify(arr, longestNonLeafIndex);
		}
	}

	private void maxHeapify(int arr[], int longestNonLeafIndex) {
		// the left element's index which is 2*i+1 (for zero based indexed
		// array)
		int left = 2 * longestNonLeafIndex + 1;

		// right index = 2*i+2;
		int right = 2 * longestNonLeafIndex + 2;

		// index can't be negative so initialize largest index , it will be used
		// later
		int largestElementIndex = -1;

		// check if left index lies within the heap.
		// if element at left index is greater than root element,means max heap
		// property is violated
		// so for this we need to make left index as largest index value as of
		// now
		if (left < heapSize && arr[left] > arr[longestNonLeafIndex]) {
			largestElementIndex = left;
		} else {
			// if max heap property is not violated copy the root's index in
			// largestElementIndex
			largestElementIndex = longestNonLeafIndex;
		}

		// check to see the right sub tree for max heap property violation
		// here the largestElementIndex is calculated from previous step
		if (right < heapSize && arr[right] > arr[largestElementIndex]) {
			largestElementIndex = right;
		}

		// if root index is not the largest index then swap the largest element
		// with root element
		if (largestElementIndex != longestNonLeafIndex) {
			int temp = arr[longestNonLeafIndex];
			arr[longestNonLeafIndex] = arr[largestElementIndex];
			arr[largestElementIndex] = temp;

			// after swap, recursively call the MAX_HEAPIFY on the largest index
			// root element
			maxHeapify(arr, largestElementIndex);
		}
	}

	private void heapSort(int arr[]) {
		// max heap is built with heapSize initialized
		buildMaxHeap(arr);

		// starting from end loop through entire array
		for (int i = arr.length - 1; i >= 0; i--) {

			// first index of the array of max heap will contain the max value
			// of the array
			// set the largest element to the end of array
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// reduce the heap window by 1
			heapSize = heapSize - 1;

			// call it to build max heap for remaining array element.
			maxHeapify(arr, 0);
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		HeapSort sort = new HeapSort();
		System.out.println("data Before sorting " + Arrays.toString(arr));
		sort.heapSort(arr);
		System.out.println("data After sorting " + Arrays.toString(arr));
	}
}