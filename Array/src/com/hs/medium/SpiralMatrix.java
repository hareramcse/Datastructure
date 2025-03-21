package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return list;

		int row = matrix.length;
		int col = matrix[0].length;

		int left = 0, right = col - 1, top = 0, bottom = row - 1, dir = 0;

		while (left <= right && top <= bottom) {
			if (dir == 0) {
				for (int i = left; i <= right; i++) {
					list.add(matrix[top][i]);
				}
				dir = 1;
				top++;
			} else if (dir == 1) {
				for (int i = top; i <= bottom; i++) {
					list.add(matrix[i][right]);
				}
				dir = 2;
				right--;
			} else if (dir == 2) {
				for (int i = right; i >= left; i--) {
					list.add(matrix[bottom][i]);
				}
				dir = 3;
				bottom--;
			} else if (dir == 3) {
				for (int i = bottom; i >= top; i--) {
					list.add(matrix[i][left]);
				}
				dir = 0;
				left++;
			}
		}

		return list;
	}

	public static void main(String[] args) {
		SpiralMatrix obj = new SpiralMatrix();
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		List<Integer> result = obj.spiralOrder(matrix);
		System.out.println(result);
	}
}
