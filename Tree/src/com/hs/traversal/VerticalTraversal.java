package com.hs.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.hs.tree.Node;

public class VerticalTraversal {
	public List<List<Integer>> verticalTraversal(Node root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		Pair pair = new Pair(root, 0);
		map = verticalTraversalUtil(root, map, pair);
		List<List<Integer>> result = new ArrayList<>();
		for (Integer key : map.keySet()) {
			List<Integer> list = map.get(key);
			result.add(list);
		}
		return result;
	}

	public Map<Integer, List<Integer>> verticalTraversalUtil(Node root, Map<Integer, List<Integer>> map, Pair pair) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(pair);
		while (!queue.isEmpty()) {
			Pair curr = queue.poll();
			int hd = curr.hd;
			
			List<Integer> list = map.get(hd);
			if (list == null) {
				list = new ArrayList<>();
				list.add(curr.node.data);
			} else {
				list.add(curr.node.data);
			}
			map.put(hd, list);

			if (curr.node.left != null) {
				queue.add(new Pair(curr.node.left, hd - 1));
			}

			if (curr.node.right != null) {
				queue.add(new Pair(curr.node.right, hd + 1));
			}
		}
		return map;
	}

	public static void main(String[] args) {
		VerticalTraversal tree = new VerticalTraversal();
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		List<List<Integer>> list = tree.verticalTraversal(root);
		System.out.println(list);
	}
}