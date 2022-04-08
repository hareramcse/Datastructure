package com.hs.bst;

public class NextGreaterLetter {
	private char nextGreatestLetter(char[] arr, char target) {
		int n = arr.length;
		int start = 0;
		int end = n - 1;
		char ans = arr[0];
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target)
				start = mid + 1;
			if (arr[mid] > target) {
				ans = arr[mid];
				ans = (char) Math.min(ans, arr[mid]);
			}

			if (arr[mid] < target)
				start = mid + 1;
			else if (arr[mid] > target)
				end = mid - 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		NextGreaterLetter ngl = new NextGreaterLetter();
		char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		char target = 'd';
		char nextGreatestLetter = ngl.nextGreatestLetter(arr, target);
		System.out.println(nextGreatestLetter);
	}
}
