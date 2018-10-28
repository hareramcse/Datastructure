package com.hs.array.arrangement;

import java.util.Arrays;

public class QuickSortDoublePivot {
	public void sort(int[] input) {
		sort(input, 0, input.length - 1);
	}

	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private void sort(int[] input, int lowIndex, int highIndex) {

		if (highIndex <= lowIndex)
			return;

		int pivot1 = input[lowIndex];
		int pivot2 = input[highIndex];

		if (pivot1 > pivot2) {
			swap(input, lowIndex, highIndex);
			pivot1 = input[lowIndex];
			pivot2 = input[highIndex];
		} else if (pivot1 == pivot2) {
			while (pivot1 == pivot2 && lowIndex < highIndex) {
				lowIndex++;
				pivot1 = input[lowIndex];
			}
		}

		int i = lowIndex + 1;
		int lt = lowIndex + 1;
		int gt = highIndex - 1;

		while (i <= gt) {

			if (input[i] < pivot1) {
				swap(input, i++, lt++);
			} else if (pivot2 < input[i]) {
				swap(input, i, gt--);
			} else {
				i++;
			}

		}

		swap(input, lowIndex, --lt);
		swap(input, highIndex, ++gt);

		sort(input, lowIndex, lt - 1);
		sort(input, lt + 1, gt - 1);
		sort(input, gt + 1, highIndex);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 14, 5, 25, 4, 34, 22 };
		QuickSortDoublePivot qsdp = new QuickSortDoublePivot();
		qsdp.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
