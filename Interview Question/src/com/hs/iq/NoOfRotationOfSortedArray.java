package com.hs.iq;

// 45,56,76,89,98,105,9,12,23,34,42,44
public class NoOfRotationOfSortedArray {// here goal is to find out the minimum
										// value index in the array

	// time complexity= O(logn)
	private int countNoOfRotation(int arr[]) {
		int length = arr.length;
		int low = 0, high = length - 1;
		while (low <= high) {
			// means whole array is all ready sorted
			if (arr[low] <= arr[high]) {
				return low;
			} else {
				int mid = low + (high - low) / 2;
				int next = (mid + 1) % length;// this modulo property is for
												// circular array
				int prev = (mid + length - 1) % length;
				// pivot element=both next and previous element is greater
				if (arr[mid] < arr[next] && arr[mid] < arr[prev]) {
					return mid;
				} else if (arr[mid] < arr[high]) {
					high = mid - 1;
				} else if (arr[mid] > arr[low]) {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	// time complexity = O(n)
	public int countRotation(int arr[]) {
		int min = arr[0];
		int minIndex = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		int arr[] = { 45, 56, 76, 89, 98, 105, 9, 12, 23, 34, 42, 44 }; // pre
																		// condition
																		// is
																		// there
																		// should
																		// be no
																		// any
																		// duplicate
																		// element
		NoOfRotationOfSortedArray noOfRotationOfSortedArray = new NoOfRotationOfSortedArray();
		int count = noOfRotationOfSortedArray.countNoOfRotation(arr);
		System.out.println("no is roatated " + count + " times");
		int count1 = noOfRotationOfSortedArray.countRotation(arr);
		System.out.println(count1);
	}
}
