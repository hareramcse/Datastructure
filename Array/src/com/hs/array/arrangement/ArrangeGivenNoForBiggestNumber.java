package com.hs.array.arrangement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrangeGivenNoForBiggestNumber {

	private void printLargest(List<String> list) {

		Collections.sort(list, new Comparator<String>() {

			// A comparison function which is used by sort() in printLargest()
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

	public static void main(String[] args) {
		ArrangeGivenNoForBiggestNumber array = new ArrangeGivenNoForBiggestNumber();

		List<String> arr = new ArrayList<String>();

		// output should be 6054854654
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		array.printLargest(arr);
	}
}