package com.hs.medium;

public class CelebrityProblem {
	public int getId(int[][] arr, int n) {
		int candidate = 0;
		for (int i = 1; i < n; i++) {
			if (arr[candidate][i] == 1) {
				candidate = i; // Candidate knows i, so candidate cannot be celebrity
			}
		}

		for (int i = 0; i < n; i++) {
			if (i == candidate)
				continue;

			if (arr[candidate][i] == 1 || arr[i][candidate] == 0) {
				return -1;
			}
		}

		return candidate;
	}

	public static void main(String[] args) {
		CelebrityProblem obj = new CelebrityProblem();
		int N = 4;

		int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
		int id = obj.getId(MATRIX, N);
		System.out.println(id);
	}
}