package com.hs.gs;

public class FirstNonRepeating {

	/*
	 * The function returns index of the first non-repeating character in a string.
	 * If all characters are repeating then returns INT_MAX
	 */
	static int firstNonRepeating(String str) {
		int NO_OF_CHARS = 256;

		// Initialize all characters
		// as absent.
		int arr[] = new int[NO_OF_CHARS];
		for (int i = 0; i < NO_OF_CHARS; i++)
			arr[i] = -1;

		// After below loop, the
		// value of arr[x] is going
		// to be index of x if x
		// appears only once. Else
		// the value is going to be
		// either -1 or -2.
		for (int i = 0; i < str.length(); i++) {
			if (arr[str.charAt(i)] == -1)
				arr[str.charAt(i)] = i;
			else
				arr[str.charAt(i)] = -2;
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < NO_OF_CHARS; i++)

			// If this character occurs
			// only once and appears before
			// the current result, then
			// update the result
			if (arr[i] >= 0)
				res = Math.min(res, arr[i]);

		return res;
	}

	// Driver Code
	public static void main(String args[]) {
		String str = "geeksforgeeks";

		int index = firstNonRepeating(str);
		if (index == Integer.MAX_VALUE)
			System.out.print("Either all characters are " + "repeating or string is empty");
		else
			System.out.print("First non-repeating character" + " is " + str.charAt(index));
	}
}
