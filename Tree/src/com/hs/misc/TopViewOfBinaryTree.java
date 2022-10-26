package com.hs.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.hs.tree.Node;

// find the vertical order traversal, get the 1st node of each level
class TopViewOfBinaryTree {
	public List<Integer> topView(Node root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		Pair pair = new Pair(root, 0);
		map = verticalTraversalUtil(root, map, pair);
		List<Integer> result = new ArrayList<>();
		for (Integer key : map.keySet()) {
			List<Integer> list = map.get(key);
			result.add(list.get(0));
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
		TopViewOfBinaryTree tree = new TopViewOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in top view of Binary Tree");
		List<Integer> list = tree.topView(root);
		System.out.println(list);
	}
}