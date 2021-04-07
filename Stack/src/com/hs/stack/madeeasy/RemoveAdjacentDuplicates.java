package com.hs.stack.madeeasy;

public class RemoveAdjacentDuplicates {

	public int removeAdjacentDuplicates(int[] arr) {
		int stkptr = -1;
		int i = 0;
		while (i < arr.length) {
			if (stkptr == -1 || arr[stkptr] != arr[i]) {
				stkptr++;
				arr[stkptr] = arr[i];
				i++;
			} else {
				while (i < arr.length && arr[stkptr] == arr[i]) {
					i++;
				}
				stkptr--;
			}
		}
		return stkptr;
	}

	public static void main(String[] args) {
		RemoveAdjacentDuplicates adjacentDuplicates = new RemoveAdjacentDuplicates();
		int[] arr = { 1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5 };
		int index = adjacentDuplicates.removeAdjacentDuplicates(arr);
		for (int i = 0; i <= index; i++) {
			System.out.println(" " + arr[i]);
		}
	}
}
