package com.hs.connectivity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfGroupsFromFriends {

	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	NoOfGroupsFromFriends(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
	}

	private void addRelation(int source, int destination) {
		source--;
		destination--;
		adj[source].add(destination);
		adj[destination].add(source);
	}

	// Returns count of not visited nodes reachable from v using DFS.
	private int countUtil(int source, boolean visited[]) {
		int count = 1;
		visited[source] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[source].iterator();
		while (it.hasNext()) {
			int currentAdj = it.next();
			if (!visited[currentAdj])
				count = count + countUtil(currentAdj, visited);
		}
		return count;
	}

	// A DFS based function to Count number of existing groups and number of new
	// groups
	// that can be formed using a member of every group.
	private void countGroups() {

		// Mark all the vertices as not visited(set as false by default in java)
		boolean visited[] = new boolean[noOfVertices];
		int existingGroups = 0, newGroups = 1;

		for (int i = 0; i < noOfVertices; i++) {

			// If not in any group.
			if (visited[i] == false) {
				existingGroups++;

				// Number of new groups that can be formed.
				newGroups = newGroups * countUtil(i, visited);
			}
		}

		if (existingGroups == 1)
			newGroups = 0;

		System.out.println("No. of existing groups are " + existingGroups);
		System.out.println("No. of new groups that " + "can be formed are " + newGroups);
	}

	// Driver code
	public static void main(String[] args) {
		NoOfGroupsFromFriends graph = new NoOfGroupsFromFriends(6);
		graph.addRelation(1, 2); // 1 and 2 are friends
		graph.addRelation(3, 4); // 3 and 4 are friends
		graph.addRelation(5, 6); // 5 and 6 are friends

		graph.countGroups();
	}

}