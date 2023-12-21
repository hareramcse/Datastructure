package com.hs.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		Queue<Pair> maxHeap = new PriorityQueue<>(
				(a, b) -> ((b.value == a.value) ? (b.key - a.key) : (b.value - a.value)));
		for (int num : arr) {
			maxHeap.add(new Pair(num, Math.abs(num - x)));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		List<Integer> ans = new ArrayList<>();
		while (!maxHeap.isEmpty()) {
			ans.add(maxHeap.poll().key);
		}
		Collections.sort(ans);
		return ans;
	}

	public static void main(String[] args) {
		FindKClosestElements sol = new FindKClosestElements();
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4;
		int x = 3;
		List<Integer> res = sol.findClosestElements(arr, k, x);
		System.out.println(res);
	}
}