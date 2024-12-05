package com.hs.medium;

import java.util.Stack;

public class CelebrityProblem {
	public int getId(int[][] arr, int n) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			stack.push(i);
		}

		while (stack.size() > 1) {
			int a = stack.pop();
			int b = stack.pop();
			if (arr[a][b] == 0) {
				stack.push(a); // if a does not know b then a could be celebrity
			} else {
				stack.push(b);
			}
		}

		int candidate = stack.pop();
		for (int i = 0; i < n; i++) {
			if (i == candidate)
				continue;

			// if candidate knows someone or someone does not know candidate
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