package com.hs.sorting;

import java.util.Arrays;

public class MergeTest {

	public static void merge(int[] left, int right[], int[] result) {
		int i = 0, j = 0, k = 0;
		int sizeOfLeftArray = left.length;
		int sizeOfRightArray = right.length;

		while (i < sizeOfLeftArray && j < sizeOfRightArray) {
			if (left[i] < right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[k++];
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
		int[] left = {5, 6, 3, 4, 8, 9};
		int[] right = {11, 15, 7, 8, 2};
		int n = left.length + right.length;
		int[] result = new int[n];
		
		MergeTest.merge(left, right, result);
		
		System.out.println(Arrays.toString(result));
	}
}
