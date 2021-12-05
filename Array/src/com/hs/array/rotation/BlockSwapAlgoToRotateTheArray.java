package com.hs.array.rotation;

import java.util.Arrays;

/*
 * initialize A = arr[0..d-1] and B = arr[d..n-1]
1) Do following until size of A is equal to size of B

  a)  If A is shorter, divide B into Bl and Br such that Br is of same 
       length as A. Swap A and Br to change ABlBr into BrBlA. Now A
       is at its final place, so recur on pieces of B.  

   b)  If A is longer, divide A into Al and Ar such that Al is of same 
       length as B Swap Al and B to change AlArB into BArAl. Now B
       is at its final place, so recur on pieces of A.

2)  Finally when A and B are of equal size, block swap them.
 * */
public class BlockSwapAlgoToRotateTheArray {
	private void leftRotate(int arr[], int d) {
		int n = arr.length;
		int i, j;
		if (d == 0 || d == n)
			return;
		
		i = d;
		j = n - d;
		while (i != j) {
			if (i < j) /* A is shorter */
			{
				swap(arr, d - i, d + j - i, i);
				j -= i;
			} else /* B is shorter */
			{
				swap(arr, d - i, d, j);
				i -= j;
			}
			// printArray(arr, 7);
		}
		/* Finally, block swap A and B */
		swap(arr, d - i, d, i);
	}

	private void swap(int arr[], int fi, int si, int d) {
		int i, temp;
		for (i = 0; i < d; i++) {
			temp = arr[fi + i];
			arr[fi + i] = arr[si + i];
			arr[si + i] = temp;
		}
	}

	public static void main(String[] args) {
		BlockSwapAlgoToRotateTheArray array = new BlockSwapAlgoToRotateTheArray();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int d = 2;
		array.leftRotate(arr, d);
		System.out.println(Arrays.toString(arr));
	}

}
