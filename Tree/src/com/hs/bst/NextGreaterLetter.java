package com.hs.bst;

//744. Find Smallest Letter Greater Than Target Leetcode
public class NextGreaterLetter {
	private char nextGreatestLetter(char[] arr, char value) {
		int n = arr.length;
		int low = 0;
		int high = n - 1;
		char res = arr[0];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (value == arr[mid])
				low = mid + 1;
			if (value < arr[mid]) {
				high = mid - 1;
				res = arr[mid];
			} else {
				low = mid + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NextGreaterLetter ngl = new NextGreaterLetter();
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		char value = 'd';
		char nextGreatestLetter = ngl.nextGreatestLetter(arr, value);
		System.out.println(nextGreatestLetter);
	}
}