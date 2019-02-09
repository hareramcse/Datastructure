package com.hs.basic;

public class FindMaxTwoNumber {
	public void printTwoMaxNumbers(int[] arr) {
		int maxOne = 0;
		int maxTwo = 0;
		for (int i = 0; i < arr.length; i++) {
			if (maxOne < arr[i]) {
				maxTwo = maxOne;
				maxOne = arr[i];
			} else if (maxTwo < arr[i]) {
				maxTwo = arr[i];
			}
		}
		System.out.println("First Max Number: " + maxOne);
		System.out.println("Second Max Number: " + maxTwo);
	}

	public static void main(String a[]) {
		int arr[] = { 5, 34, 78, 2, 45, 1, 99, 23 };
		FindMaxTwoNumber tmn = new FindMaxTwoNumber();
		tmn.printTwoMaxNumbers(arr);
	}
}