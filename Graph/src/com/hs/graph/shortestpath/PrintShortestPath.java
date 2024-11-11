package com.hs.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrintShortestPath {

	public List<Integer> shortestPath(int n, int m, int edges[][]) {
		List<List<Node>> adjList = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			
			adjList.get(u).add(new Node(v, w));
			adjList.get(v).add(new Node(u, w));
		}

		Queue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
		pq.add(new Node(1, 0));

		int[] distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		
		// as vertex start from 1 not from 0 that is why here n + 1
		// initialize the parent array with index of vertex
		int[] parents = new int[n + 1];
		for (int i = 1; i <= n; i++)
			parents[i] = i;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int u = node.destination;
			int weight = node.weight;
			pq.remove();

			for (Node adjNode : adjList.get(u)) {
				int v = adjNode.destination;
				int edgeWeight = adjNode.weight;
				
				if (weight + edgeWeight < distance[v]) {
					distance[v] = weight + edgeWeight;
					pq.add(new Node(v, distance[v]));
					
					parents[v] = u;
				}
			}
		}

		List<Integer> path = new LinkedList<Integer>();
		int node = n;
		if (distance[n] == Integer.MAX_VALUE) {
			path.add(-1);
			return path;
		}
		
		while (parents[node] != node) {
			path.add(node);
			node = parents[node];
		}
		
		// add the source node after while loop
		path.add(1);
		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) {
		PrintShortestPath obj = new PrintShortestPath();
		int[][] matrix = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
		int V = 5;
		int E = 6;
		List<Integer> result = obj.shortestPath(V, E, matrix);
		System.out.println(result);
	}
}