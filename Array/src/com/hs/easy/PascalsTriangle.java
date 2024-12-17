package com.hs.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }

        // Base case: the first row is always [1]
        List<Integer> list = new ArrayList<>();
        list.add(1);
        triangle.add(list);

        // Build each row
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);

            // The first element is always 1
            row.add(1);

            // Compute the intermediate values
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last element is always 1
            row.add(1);

            // Add the row to the triangle
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt.generate(5));
    }
}