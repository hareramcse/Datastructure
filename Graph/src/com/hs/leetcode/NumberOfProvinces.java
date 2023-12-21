package com.hs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
	public int findCircleNum(int[][] isConnected) {
		List<List<Integer>> adjList = convertMatrixTOAdjList(isConnected);
		boolean[] visited = new boolean[adjList.size()];
		int count = 0;
		for (int i = 0; i < adjList.size(); i++) {
			if (!visited[i]) {
				count++;
				dfs(i, adjList, visited);
			}
		}
		return count;
	}

	private List<List<Integer>> convertMatrixTOAdjList(int[][] matrix) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < matrix.length; i++) {
			// here i -> j means there is a edge between i -> j
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1 && i != j) {
					adjList.get(i).add(j);
					adjList.get(j).add(i);
				}
			}
		}
		return adjList;
	}

	private void dfs(int source, List<List<Integer>> adjList, boolean[] visited) {
		visited[source] = true;
		for (int adjNode : adjList.get(source)) {
			if (!visited[adjNode]) {
				dfs(adjNode, adjList, visited);
			}
		}
	}

	public static void main(String[] args) {
		NumberOfProvinces obj = new NumberOfProvinces();
		int[][] matrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		int result = obj.findCircleNum(matrix);
		System.out.println(result);
	}
}
