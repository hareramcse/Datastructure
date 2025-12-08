package com.hs.sorting;

import java.util.Arrays;

public class MergeSort {
	private void partitionAndMerge(int[] arr) {
		int length = arr.length;
		int midLength = arr.length / 2;
		if (length <= 1) {
			return;
		}
		// Split the array in two equal parts
		int[] left = new int[midLength];
		int[] right = new int[length - midLength];
		// fill the left array with the half element of the original array
		for (int i = 0; i < midLength; i++) {
			left[i] = arr[i];
		}
		// fill the right array with the remaining element of the original array
		for (int i = midLength; i < length; i++) {
			right[i - midLength] = arr[i];
		}
		partitionAndMerge(left);
		partitionAndMerge(right);

		// Merge both halves together, overwriting to original array
		merge(left, right, arr);
	}

	private void merge(int[] left, int[] right, int[] result) {
		// Index Position in left array - starting with first element
		int i = 0;
		// Index Position in right array - starting with first element
		int j = 0;
		// Index Position in resulting array - starting with first position
		int k = 0;
		int sizeOfLeftArray = left.length;
		int sizeOfRightArray = right.length;
		// Compare with left array element and right array element,
		// and move smaller element in resulting array
		while (i < sizeOfLeftArray && j < sizeOfRightArray) {
			if (left[i] < right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		while (i < sizeOfLeftArray) {
			result[k++] = left[i++];
		}
		while (j < sizeOfRightArray) {
			result[k++] = right[j++];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 6, 7, 5, 4, 3, 2 };
		MergeSort mergeSort = new MergeSort();
		System.out.println("data Before sorting " + Arrays.toString(arr));
		mergeSort.partitionAndMerge(arr);
		// Check the output which is sorted array
		System.out.println("data After sorting " + Arrays.toString(arr));
	}
}
