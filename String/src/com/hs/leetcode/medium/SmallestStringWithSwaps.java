package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class UnionFind {
	private int[] parent;

	public UnionFind(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int getAbsoluteParent(int i) {
		if (parent[i] == i) {
			return i;
		}

		parent[i] = getAbsoluteParent(parent[i]);
		return parent[i];
	}

	public void unify(int i, int j) {
		int absoluteParentI = getAbsoluteParent(i);
		int absoluteParentJ = getAbsoluteParent(j);
		if (absoluteParentI != absoluteParentJ) {
			parent[absoluteParentJ] = absoluteParentI;
		}
	}
}

public class SmallestStringWithSwaps {
	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		char[] str = s.toCharArray();
		Map<Integer, Queue<Character>> map = new HashMap<>();
		UnionFind uf = new UnionFind(str.length);

		for (List<Integer> pair : pairs) {
			uf.unify(pair.get(0), pair.get(1));
		}

		for (int i = 0; i < str.length; i++) {
			int parentId = uf.getAbsoluteParent(i);
			Queue<Character> pq = map.getOrDefault(parentId, new PriorityQueue<>());
			pq.offer(str[i]);
			map.putIfAbsent(parentId, pq);
		}

		for (int i = 0; i < str.length; i++) {
			int parentId = uf.getAbsoluteParent(i);
			str[i] = map.get(parentId).poll();
		}
		return new String(str);
	}

	public static void main(String[] args) {
		SmallestStringWithSwaps obj = new SmallestStringWithSwaps();
		String s = "dcab";
		List<List<Integer>> listOfList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(3);
		listOfList.add(list);

		list = new ArrayList<>();
		list.add(1);
		list.add(2);
		listOfList.add(list);
		String result = obj.smallestStringWithSwaps(s, listOfList);
		System.out.println(result);
	}
}
