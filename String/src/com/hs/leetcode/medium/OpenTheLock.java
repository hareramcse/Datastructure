package com.hs.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
		if (target.isEmpty())
			return -1;

		Set<String> visited = new HashSet<>();
		for (String deadend : deadends) {
			visited.add(deadend);
		}

		Queue<String> queue = new LinkedList<>();
		int level = 0;
		queue.offer("0000");
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String currentLock = queue.poll();
				if (visited.contains(currentLock))
					continue;
				if (currentLock.equals(target))
					return level;

				for (String nextLock : getNextStates(currentLock)) {
					if (!visited.contains(nextLock))
						queue.offer(nextLock);
				}
				visited.add(currentLock);
			}
			level++;
		}
		return -1;
	}

	private Set<String> getNextStates(String lock) {
		Set<String> newLocks = new HashSet<>();
		char[] lockChar = lock.toCharArray();
		for (int i = 0; i < 4; i++) {
			char ch = lockChar[i];
			lockChar[i] = ch == '9' ? '0' : (char) (ch + 1);
			newLocks.add(new String(lockChar));

			lockChar[i] = ch == '0' ? '9' : (char) (ch - 1);
			newLocks.add(new String(lockChar));
			lockChar[i] = ch;
		}
		return newLocks;
	}

	public static void main(String[] args) {
		OpenTheLock obj = new OpenTheLock();
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";
		int result = obj.openLock(deadends, target);
		System.out.println(result);
	}
}