package com.hs.connectivity;

import java.util.ArrayList;

public class CheckArrayOfStringCanFormCircle {

	// Return true if an order among strings is possible
	public static boolean possibleOrderAmongString(String s[], int n) {
		int m = 26;
		boolean mark[] = new boolean[m];
		int in[] = new int[26];
		int out[] = new int[26];

		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < m; i++)
			adj.add(new ArrayList<>());

		// Process all strings one by one
		for (int i = 0; i < n; i++) {

			// Find first and last characters
			int f = (int) (s[i].charAt(0) - 'a');
			int l = (int) (s[i].charAt(s[i].length() - 1) - 'a');

			// Mark the characters
			mark[f] = mark[l] = true;

			// Increase indegree and outdegree count
			in[l]++;
			out[f]++;

			// Add an edge in graph
			adj.get(f).add(l);
		}

		// If for any character indegree is not equal to
		// outdegree then ordering is not possible
		for (int i = 0; i < m; i++) {
			if (in[i] != out[i])
				return false;
		}
		return isConnected(adj, mark, s[0].charAt(0) - 'a');
	}

	// Returns true if all vertices are strongly
	// connected i.e. can be made as loop
	public static boolean isConnected(ArrayList<ArrayList<Integer>> adj, boolean mark[], int src) {
		boolean visited[] = new boolean[26];

		// Perform a dfs from src
		dfs(adj, visited, src);
		for (int i = 0; i < 26; i++) {

			/*
			 * I character is marked (i.e. it was first or last character of some string)
			 * then it should be visited in last dfs (as for looping, graph should be
			 * strongly connected)
			 */
			if (mark[i] && !visited[i])
				return false;
		}

		// If we reach that means graph is connected
		return true;
	}

	// Utility method for a depth first
	// search among vertices
	public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], int src) {
		visited[src] = true;
		for (int i = 0; i < adj.get(src).size(); i++)
			if (!visited[adj.get(src).get(i)])
				dfs(adj, visited, adj.get(src).get(i));
	}

	// Driver code
	public static void main(String[] args) {
		String s[] = { "ab", "bc", "cd", "de", "ed", "da" };
		int n = s.length;

		if (possibleOrderAmongString(s, n))
			System.out.println("Ordering is possible");
		else
			System.out.println("Ordering is not possible");
	}

}