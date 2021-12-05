package com.hs.array.arrangement;

import java.util.Arrays;

public class ThreeWayPartitioningQuickSort {

	private void sort(int[] input) {
		// input=shuffle(input);
		sort(input, 0, input.length - 1);
	}

	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public void sort(int[] input, int lowIndex, int highIndex) {

		if (highIndex <= lowIndex)
			return;

		int lt = lowIndex;
		int gt = highIndex;
		int i = lowIndex + 1;

		int pivotIndex = lowIndex;
		int pivotValue = input[pivotIndex];

		while (i <= gt) {

			if (input[i] < pivotValue) {
				swap(input, i++, lt++);
			} else if (pivotValue < input[i]) {
				swap(input, i, gt--);
			} else {
				i++;
			}
		}
		sort(input, lowIndex, lt - 1);
		sort(input, gt + 1, highIndex);
	}

	public static void main(String[] args) {
		ThreeWayPartitioningQuickSort twp = new ThreeWayPartitioningQuickSort();
		int arr[] = { 1, 14, 5, 25, 4, 34, 22 };
		twp.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
