package com.hs.leetcode.medium;

import java.util.List;

public class KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		boolean visited[] = new boolean[n];

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				DFSUtil(rooms, i, visited);
				count++;
			}
		}
		boolean result = count == 1 ? true : false;
		return result;
	}

	private void DFSUtil(List<List<Integer>> rooms, int source, boolean visited[]) {
		visited[source] = true;
		for (Integer adjNode : rooms.get(source)) {
			if (!visited[adjNode]) {
				DFSUtil(rooms, adjNode, visited);
			}
		}
	}
}
