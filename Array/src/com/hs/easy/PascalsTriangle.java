package com.hs.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();
		if (numRows == 0) {
			return triangle;
		}

		// Base case: first row is always [1]
		List<Integer> list = new ArrayList<>();
		list.add(1);
		triangle.add(list);

		for (int i = 1; i < numRows; i++) {
			List<Integer> prevRow = triangle.get(i - 1);
			List<Integer> row = new ArrayList<>();
			row.add(1); // First element is always 1

			for (int j = 1; j < i; j++) {
				row.add(prevRow.get(j - 1) + prevRow.get(j)); // Compute the intermediate values
			}

			row.add(1); // Last element is always 1
			triangle.add(row);
		}

		return triangle;
	}

	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();
		System.out.println(pt.generate(5));
	}
}