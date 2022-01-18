package com.hs.connectivity;

public class FindDegreeOfVertex {

	private int noOfVertices;
	private int[][] dir;

	FindDegreeOfVertex(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		dir = new int[noOfVertices][];
		for (int i = 0; i < noOfVertices; i++)
			dir[i] = new int[noOfVertices];
	}

	private FindDegreeOfVertex createGraph(int noOfVertices) {
		FindDegreeOfVertex graph = new FindDegreeOfVertex(noOfVertices);

		// direction from 0
		graph.dir[0][1] = 1;
		graph.dir[0][2] = 1;
		graph.dir[0][3] = 1;

		// direction from 1
		graph.dir[1][0] = 1;
		graph.dir[1][3] = 1;

		// direction from 2
		graph.dir[2][0] = 1;
		graph.dir[2][3] = 1;

		// direction from 3
		graph.dir[3][0] = 1;
		graph.dir[3][1] = 1;
		graph.dir[3][2] = 1;

		return graph;
	}

	private int findDegree(int source) {
		int degree = 0;
		for (int i = 0; i < noOfVertices; i++) {
			if (dir[source][i] == 1)
				degree++;
		}

		// below line is to account for self loop in graph
		// check sum of degrees in graph theorem
		if (dir[source][source] == 1)
			degree++;
		return degree;
	}

	// Driver code
	public static void main(String[] args) {
		FindDegreeOfVertex graph = new FindDegreeOfVertex(4);
		// Creating a Graph
		graph = graph.createGraph(4);

		int source = 0;

		int degree = graph.findDegree(source);
		System.out.println(degree);
	}

}