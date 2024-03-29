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
				stack.push(a);
			} else {
				stack.push(b);
			}
		}

		int x = stack.pop();
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (i == x)
				continue;

			// if x knows someone or someone does not know x
			if (arr[x][i] == 1 || arr[i][x] == 0) {
				flag = false;
				break;
			}
		}

		if (!flag)
			return -1;
		return x;
	}

	public static void main(String[] args) {
		CelebrityProblem obj = new CelebrityProblem();
		int N = 4;

		int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
		int id = obj.getId(MATRIX, N);
		System.out.println(id);
	}
}