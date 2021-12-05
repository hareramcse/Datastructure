package com.hs.array.arrangement;

import java.util.Arrays;

public class ArrangeAlternatePositiveAndNegativeNo {

	private void rearrange(int arr[]) {
		int n = arr.length;
		int i = -1, temp = 0;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int positiveNoStartingIndex = i + 1, negativeNoStartingIndex = 0;

		// Increment the negative index by 2 and positive index by 1, i.e.,
		// swap every alternate negative number with next positive number
		while (positiveNoStartingIndex < n && negativeNoStartingIndex < positiveNoStartingIndex
				&& arr[negativeNoStartingIndex] < 0) {
			temp = arr[negativeNoStartingIndex];
			arr[negativeNoStartingIndex] = arr[positiveNoStartingIndex];
			arr[positiveNoStartingIndex] = temp;
			positiveNoStartingIndex++;
			negativeNoStartingIndex += 2;
		}
	}

	public static void main(String[] args) {
		ArrangeAlternatePositiveAndNegativeNo array = new ArrangeAlternatePositiveAndNegativeNo();
		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		array.rearrange(arr);
		System.out.println(Arrays.toString(arr));

	}
}
