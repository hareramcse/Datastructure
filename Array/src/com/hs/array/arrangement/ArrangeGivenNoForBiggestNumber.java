package com.hs.array.arrangement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrangeGivenNoForBiggestNumber {

	// The main function that prints the arrangement with the largest 
	// value the function accepts a vector of strings
	void printLargest(List<String> list) {

		Collections.sort(list, new Comparator<String>() {

			// A comparison function which is used by
			// sort() in printLargest()
			@Override
			public int compare(String X, String Y) {

				// first append Y at the end of X
				String XY = X + Y;

				// then append X at the end of Y
				String YX = Y + X;

				// Now see which of the two formed number is greater
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		Iterator<String> it = list.iterator();

		while (it.hasNext())
			System.out.print(it.next());

	}

	// driver program
	public static void main(String[] args) {
		ArrangeGivenNoForBiggestNumber agnfbn=new ArrangeGivenNoForBiggestNumber();

		List<String> arr = new ArrayList<String>();

		// output should be 6054854654
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		agnfbn.printLargest(arr);

		// output should be 777776
		/*
		 * arr.add("7"); arr.add("776"); arr.add("7"); arr.add("7");
		 */

		// output should be 998764543431
		/*
		 * arr.add("1"); arr.add("34"); arr.add("3"); arr.add("98"); arr.add("9");
		 * arr.add("76"); arr.add("45"); arr.add("4");
		 */
	}
}