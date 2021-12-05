package com.hs.array.traditional.sorting;

import java.util.Arrays;
import java.util.Random;

// best or average case O(nlogn) and in worst case O(n2)
public class QuickSort {

	private void sort(int arr[]) {
		sort(arr, 0, arr.length - 1);
	}

	private void sort(int arr[], int start, int end) {
		if (start >= end) {
			return;
		}
		int pIndex = randomizePartition(arr, start, end);
		sort(arr, start, pIndex - 1);
		sort(arr, pIndex + 1, end);
	}

	private int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				int tmp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = tmp;
				pIndex++;
			}
		}
		int tmp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end] = tmp;
		return pIndex;
	}

	private int randomizePartition(int arr[], int start, int end) {
		Random r = new Random();
		int randomIndex = r.nextInt(end - start + 1) + start;
		int tmp = arr[end];
		arr[end] = arr[randomIndex];
		arr[randomIndex] = tmp;
		return partition(arr, start, end);
	}

	public static void main(String[] args) {
		int arr[] = { 17, 5, 4, 15, 13, 18, 11 };
		QuickSort quickSort = new QuickSort();
		System.out.println("data Before sorting " + Arrays.toString(arr));
		quickSort.sort(arr);
		System.out.println("data After sorting " + Arrays.toString(arr));
	}
}