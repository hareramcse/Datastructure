package com.hs.hard;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
	public List<String> findPath(int[][] matrix, int n) {
		int[][] visited = new int[n][n];
		List<String> ans = new ArrayList<>();
		int di[] = { +1, 0, 0, -1 };
		int dj[] = { 0, -1, 1, 0 };
		if (matrix[0][0] == 1)
			solve(0, 0, matrix, n, ans, "", visited, di, dj);
		return ans;
	}

	private void solve(int i, int j, int[][] matrix, int n, List<String> ans, String move, int[][] visited, int[] di,
			int[] dj) {
		if (i == n - 1 && j == n - 1) {
			ans.add(move);
			return;
		}
		String dir = "DLRU";
		for (int index = 0; index < 4; index++) {
			int nexti = i + di[index];
			int nextj = j + dj[index];
			if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && visited[nexti][nextj] == 0
					&& matrix[nexti][nextj] == 1) {
				visited[i][j] = 1;
				solve(nexti, nextj, matrix, n, ans, move + dir.charAt(index), visited, di, dj);
				visited[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] matrix = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

		RatInMaze obj = new RatInMaze();
		List<String> res = obj.findPath(matrix, n);
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++)
				System.out.print(res.get(i) + " ");
			System.out.println();
		} else {
			System.out.println(-1);
		}
	}
}