package com.hs.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathWithUnitDistance {
	public int[] shortestPath(int[][] edges, int n, int m, int src) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);

		int[] distance = new int[n];
		for (int i = 0; i < n; i++) {
			distance[i] = (int) 1e9;
		}

		distance[src] = 0;

		while (!queue.isEmpty()) {
			Integer u = queue.poll();

			for (int adjNode : adjList.get(u)) {
				if (distance[u] + 1 < distance[adjNode]) {
					distance[adjNode] = distance[u] + 1;
					queue.add(adjNode);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (distance[i] == 1e9)
				distance[i] = -1;
		}

		return distance;
	}

	public static void main(String[] args) {
		ShortestPathWithUnitDistance obj = new ShortestPathWithUnitDistance();
		int n = 9, m = 10;
		int[][] edge = { { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 },
				{ 6, 8 } };
		int[] shortestPath = obj.shortestPath(edge, n, m, 0);
		System.out.println(Arrays.toString(shortestPath));
	}
}
