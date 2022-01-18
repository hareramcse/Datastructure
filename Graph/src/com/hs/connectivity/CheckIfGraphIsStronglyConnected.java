package com.hs.connectivity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckIfGraphIsStronglyConnected {
	private int noOfVertices;
	private Queue<Integer> adj[];
	private int Time;

	@SuppressWarnings("unchecked")
	CheckIfGraphIsStronglyConnected(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
		Time = 0;
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
	}

	// A recursive function that finds and prints strongly
	// connected components using DFS traversal
	// u --> The vertex to be visited next
	// disc[] --> Stores discovery times of visited vertices
	// low[] -- >> earliest visited vertex (the vertex with
	// minimum discovery time) that can be reached
	// from subtree rooted with current vertex
	// st -- >> To store all the connected ancestors (could be part of SCC)
	// stackMember[] --> bit/index array for faster check whether a node is in stack
	private void SCCUtil(int u, int low[], int disc[], boolean stackMember[], Stack<Integer> st) {

		// Initialize discovery time and low value
		disc[u] = Time;
		low[u] = Time;
		Time += 1;
		stackMember[u] = true;
		st.push(u);

		int n;

		// Go through all vertices adjacent to this
		Iterator<Integer> i = adj[u].iterator();

		while (i.hasNext()) {
			n = i.next();

			if (disc[n] == -1) {
				SCCUtil(n, low, disc, stackMember, st);

				// Check if the subtree rooted with v has a connection to one of the ancestors
				// of u
				// Case 1 (per above discussion on Disc and Low value)
				low[u] = Math.min(low[u], low[n]);
			} else if (stackMember[n] == true) {

				// Update low value of 'u' only if 'v' is
				// still in stack (i.e. it's a back edge,
				// not cross edge).
				// Case 2 (per above discussion on Disc
				// and Low value)
				low[u] = Math.min(low[u], disc[n]);
			}
		}

		// head node found, pop the stack and print an SCC
		// To store stack extracted vertices
		int w = -1;
		if (low[u] == disc[u]) {
			while (w != u) {
				w = (int) st.pop();
				System.out.print(w + " ");
				stackMember[w] = false;
			}
			System.out.println();
		}
	}

	// The function to do DFS traversal.It uses SCCUtil()
	private void istronglyConnected() {

		// Mark all the vertices as not visited
		// and Initialize parent and visited,
		// and ap(articulation point) arrays
		int disc[] = new int[noOfVertices];
		int low[] = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			disc[i] = -1;
			low[i] = -1;
		}

		boolean stackMember[] = new boolean[noOfVertices];
		Stack<Integer> st = new Stack<Integer>();

		// Call the recursive helper function
		// to find articulation points
		// in DFS tree rooted with vertex 'i'
		for (int i = 0; i < noOfVertices; i++) {
			if (disc[i] == -1)
				SCCUtil(i, low, disc, stackMember, st);
		}
	}

	// Driver code
	public static void main(String args[]) {

		// Create a graph given in the above diagram
		CheckIfGraphIsStronglyConnected g1 = new CheckIfGraphIsStronglyConnected(5);

		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		System.out.println("SSC in first graph ");
		g1.istronglyConnected();

		CheckIfGraphIsStronglyConnected g2 = new CheckIfGraphIsStronglyConnected(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		System.out.println("\nSSC in second graph ");
		g2.istronglyConnected();

		CheckIfGraphIsStronglyConnected g3 = new CheckIfGraphIsStronglyConnected(7);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 0);
		g3.addEdge(1, 3);
		g3.addEdge(1, 4);
		g3.addEdge(1, 6);
		g3.addEdge(3, 5);
		g3.addEdge(4, 5);
		System.out.println("\nSSC in third graph ");
		g3.istronglyConnected();

		CheckIfGraphIsStronglyConnected g4 = new CheckIfGraphIsStronglyConnected(11);
		g4.addEdge(0, 1);
		g4.addEdge(0, 3);
		g4.addEdge(1, 2);
		g4.addEdge(1, 4);
		g4.addEdge(2, 0);
		g4.addEdge(2, 6);
		g4.addEdge(3, 2);
		g4.addEdge(4, 5);
		g4.addEdge(4, 6);
		g4.addEdge(5, 6);
		g4.addEdge(5, 7);
		g4.addEdge(5, 8);
		g4.addEdge(5, 9);
		g4.addEdge(6, 4);
		g4.addEdge(7, 9);
		g4.addEdge(8, 9);
		g4.addEdge(9, 8);
		System.out.println("\nSSC in fourth graph ");
		g4.istronglyConnected();

		CheckIfGraphIsStronglyConnected g5 = new CheckIfGraphIsStronglyConnected(5);
		g5.addEdge(0, 1);
		g5.addEdge(1, 2);
		g5.addEdge(2, 3);
		g5.addEdge(2, 4);
		g5.addEdge(3, 0);
		g5.addEdge(4, 2);
		System.out.println("\nSSC in fifth graph ");
		g5.istronglyConnected();
	}

}