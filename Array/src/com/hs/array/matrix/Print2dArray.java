package com.hs.array.matrix;

import java.util.Arrays;

public class Print2dArray {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println(Arrays.deepToString(arr));

		for (int[] i : arr) {
			for (int j : i) {
				System.out.print(j +" ");
			}
		}
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			// Loop through all elements of current row
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println();
		
		System.out.println(Arrays.toString(arr[0]));
	}

}
