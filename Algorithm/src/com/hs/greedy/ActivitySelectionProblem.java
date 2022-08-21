package com.hs.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Pair {
	public int first, second;

	public Pair(int start, int finish) {
		this.first = start;
		this.second = finish;
	}
}

public class ActivitySelectionProblem {
	public void SelectActivities(int s[], int f[]) {
		List<Pair> ans = new ArrayList<>();
		Queue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.first - p2.first);

		for (int i = 0; i < s.length; i++) {
			queue.add(new Pair(f[i], s[i]));
		}

		Pair pair = queue.poll();
		int start = pair.second;
		int end = pair.first;
		ans.add(new Pair(start, end));

		while (!queue.isEmpty()) {
			Pair itr = queue.poll();
			if (itr.second >= end) {
				start = itr.second;
				end = itr.first;
				ans.add(new Pair(start, end));
			}
		}

		System.out.println("Following Activities should be selected. \n");
		for (Pair p : ans) {
			System.out.println("Activity started at: " + p.first + " and ends at " + p.second);
		}
	}

	public static void main(String[] args) {
		ActivitySelectionProblem asp = new ActivitySelectionProblem();
		int s[] = { 1, 3, 0, 5, 8, 5 };
		int f[] = { 2, 4, 6, 7, 9, 9 };
		asp.SelectActivities(s, f);
	}
}