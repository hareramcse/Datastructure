package com.hs.shortestpath;

import java.util.Arrays;

public class FloyedWarshallAlgorithm {
	public void floyedWarshall(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = (int) 1e9;
				}
				if (i == j) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == (int) 1e9) {
					matrix[i][j] = -1;
				}
			}
		}
	}

	public static void main(String[] args) {
		FloyedWarshallAlgorithm graph = new FloyedWarshallAlgorithm();
		int[][] matrix = { { 0, 5, -1, 10 }, { -1, 0, 3, -1 }, { -1, -1, 0, 1 }, { -1, -1, -1, 0 } };
		graph.floyedWarshall(matrix);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}