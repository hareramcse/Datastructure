package com.hs.leetcode.easy;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (newColor == image[sr][sc])
			return image;
		DFS(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	private void DFS(int[][] image, int row, int col, int color, int oldColor) {
		if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor)
			return;

		image[row][col] = color;

		DFS(image, row - 1, col, color, oldColor);
		DFS(image, row + 1, col, color, oldColor);
		DFS(image, row, col - 1, color, oldColor);
		DFS(image, row, col + 1, color, oldColor);
	}
}
