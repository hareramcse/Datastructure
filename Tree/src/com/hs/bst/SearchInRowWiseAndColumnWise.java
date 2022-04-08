package com.hs.bst;

public class SearchInRowWiseAndColumnWise {
	private int[] search(int[][] arr, int m, int n, int key) {
		int i = 0, j = n - 1;
		int[] res = new int[2];
		while (i >= 0 && i < m && j >= 0 && j < n) {
			if (arr[i][j] == key) {
				res[0] = j;
				res[1] = i;
				return res;
			} else if (arr[i][j] > key) {
				j--;
			} else if (arr[i][j] < key) {
				i++;
			}
		}
		return new int[0];
	}

	public static void main(String[] args) {
		SearchInRowWiseAndColumnWise bst = new SearchInRowWiseAndColumnWise();
		int[][] arr = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		int m = 4;
		int n = 4;
		int key = 35;
		int[] search = bst.search(arr, m, n, key);
		System.out.println("Element found at " + search[0] + "," + search[1]);
	}
}
