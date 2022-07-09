package com.hs.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 987. Vertical Order Traversal of a Binary Tree
public class VerticalTraversal2 {

	class Point {
		int x;
		int y;
		int val;

		public Point(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public List<List<Integer>> verticalTraversal(Node root) {
		if (root == null)
			return new ArrayList<>();

		List<Point> list = new ArrayList<>();
		verticalTraversalUtil(root, 0, 0, list);

		// Sort points based on x then y then value
		Collections.sort(list, (p1, p2) -> p1.x == p2.x ? p1.y == p2.y ? p1.val - p2.val : p2.y - p1.y : p1.x - p2.x);

		// Build treeMap with key as x value of node
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for (Point p : list) {
			List<Integer> line = map.getOrDefault(p.x, new ArrayList<>());
			line.add(p.val);
			map.put(p.x, line);
		}

		// Construct result List<List<Integer>>
		List<List<Integer>> result = new ArrayList<>();
		for (List<Integer> l : map.values())
			result.add(l);

		return result;
	}

	private void verticalTraversalUtil(Node root, int x, int y, List<Point> list) {
		if (root == null)
			return;
		list.add(new Point(x, y, root.data));
		verticalTraversalUtil(root.left, x - 1, y - 1, list);
		verticalTraversalUtil(root.right, x + 1, y - 1, list);
	}

	public static void main(String[] args) {
		VerticalTraversal2 tree = new VerticalTraversal2();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);

		tree.verticalTraversal(root);
	}
}