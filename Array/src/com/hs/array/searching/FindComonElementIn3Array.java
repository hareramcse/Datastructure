package com.hs.array.searching;

public class FindComonElementIn3Array {
	void findCommon(int arr1[], int arr2[], int arr3[]) {
		// Initialize starting indexes for arr1[], arr2[] and arr3[]
		int i = 0, j = 0, k = 0;

		// Iterate through three arrays while all arrays have elements
		while (i < arr1.length && j < arr2.length && k < arr3.length) {
			// If x = y and y = z, print any of them and move ahead
			// in all arrays
			if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				System.out.print(arr1[i] + " ");
				i++;
				j++;
				k++;
			}

			// x < y
			else if (arr1[i] < arr2[j])
				i++;

			// y < z
			else if (arr2[j] < arr3[k])
				j++;

			// We reach here when x > y and z < y, i.e., z is smallest
			else
				k++;
		}
	}

	// Driver code to test above
	public static void main(String arrgs[]) {
		FindComonElementIn3Array fc = new FindComonElementIn3Array();

		int arr1[] = { 1, 5, 10, 20, 40, 80 };
		int arr2[] = { 6, 7, 20, 80, 100 };
		int arr3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

		System.out.print("Common elements arre ");
		fc.findCommon(arr1, arr2, arr3);
	}
}
