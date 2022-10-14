package com.hs.shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrintShortestPath {

	public List<Integer> printShortestPath(int[][] matrix, int n, int m) {
		List<List<Node>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			adjList.get(matrix[i][0]).add(new Node(matrix[i][1], matrix[i][2]));
			adjList.get(matrix[i][1]).add(new Node(matrix[i][0], matrix[i][2]));
		}

		Queue<Node> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
		int[] dist = new int[n + 1];
		int[] parent = new int[n + 1];

		for (int i = 0; i < n; i++) {
			dist[i] = (int) 1e9;
			parent[i] = i;
		}

		while (!pq.isEmpty()) {
			int distance = pq.peek().distance;
			int node = pq.peek().node;

			for (Node it : adjList.get(node)) {
				int edgeDistance = it.distance;
				int adjNode = it.node;
				if (distance + edgeDistance < dist[adjNode]) {
					dist[adjNode] = distance + edgeDistance;
					parent[adjNode] = node;
				}
			}
		}

		List<Integer> path = new ArrayList<>();
		if (dist[n] == 1e9) {
			path.add(-1);
			return path;
		}

		int node = n;
		while (parent[node] != node) {
			path.add(node);
			node = parent[node];
		}
		path.add(1);
		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) {
		PrintShortestPath obj = new PrintShortestPath();
		int[][] matrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 14, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		int n = matrix.length;
		List<Integer> result = obj.printShortestPath(matrix, n, 0);
		System.out.println(result);
	}
}
