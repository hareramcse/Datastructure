package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
		// Initialize the set of deadends
		Set<String> dead = new HashSet<>(Arrays.asList(deadends));

		// If the initial state "0000" is a deadend, return -1
		if (dead.contains("0000"))
			return -1;

		Queue<String> queue = new LinkedList<>();
		queue.add("0000");

		boolean[] visited = new boolean[10000];
		visited[0] = true;
		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String current = queue.poll();

				// If we reach the target, return the number of steps
				if (current.equals(target)) {
					return steps;
				}

				// Get all the next possible states
				for (String next : getNextStates(current)) {
					// If it's not a deadend and hasn't been visited, add it to the queue
					if (!dead.contains(next) && !visited[Integer.parseInt(next)]) {
						visited[Integer.parseInt(next)] = true;
						queue.offer(next);
					}
				}
			}
			steps++; // Increment the number of steps for each level of BFS
		}

		// If we exhaust the queue without finding the target, return -1
		return -1;
	}

	private List<String> getNextStates(String current) {
		List<String> nextStates = new ArrayList<>();
		char[] chars = current.toCharArray();

		// Explore all 4 digits of the lock
		for (int i = 0; i < 4; i++) {
			char original = chars[i];
			for (int diff : new int[] { -1, 1 }) { // -1 for backward, 1 for forward
				chars[i] = (char) ((original - '0' + diff + 10) % 10 + '0');
				nextStates.add(new String(chars));
			}
			chars[i] = original; // Restore the original value after trying both directions
		}

		return nextStates;
	}

	public static void main(String[] args) {
		OpenTheLock obj = new OpenTheLock();
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";

		int result = obj.openLock(deadends, target);
		System.out.println(result);
	}
}
