package com.hs.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

	public String findOrder(String[] dict, int N, int K) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			String s1 = dict[i];
			String s2 = dict[i + 1];
			int len = Math.min(s1.length(), s2.length());
			for (int j = 0; j < len; j++) {
				// if both char are not equal it means that s1 char will come before s2 char, so
				// there will be edge between s1 char -> s2 char
				if (s1.charAt(j) != s2.charAt(j)) {
					adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
					break;
				}
			}
		}

		List<Integer> topo = topologicalSort(adjList, K);
		String ans = "";
		for (int i : topo) {
			ans = ans + (char) (i + (int) ('a'));
		}

		return ans;
	}

	private List<Integer> topologicalSort(List<List<Integer>> adjList, int V) {
		int[] indegree = new int[V];
		for (int i = 0; i < V; i++) {
			for (int j : adjList.get(i)) {
				indegree[j]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int u = queue.poll();
			result.add(u);

			for (int adjNode : adjList.get(u)) {
				indegree[adjNode]--;
				if (indegree[adjNode] == 0)
					queue.add(adjNode);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		AlienDictionary obj = new AlienDictionary();
		int N = 5, K = 4;
		String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
		String ans = obj.findOrder(dict, N, K);

		for (int i = 0; i < ans.length(); i++) {
			System.out.print(ans.charAt(i) + " ");
		}
		System.out.println("");
	}
}