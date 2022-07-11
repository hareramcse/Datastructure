package com.hs.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.hs.tree.Node;

public class VerticalTraversal {

	public List<List<Integer>> verticalTraversal(Node root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		verticalTraversalUtil(root, map, 0);

		List<List<Integer>> list = new ArrayList<>();
		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	private void verticalTraversalUtil(Node root, Map<Integer, List<Integer>> map, int d) {
		if (root == null)
			return;

		List<Integer> list = map.get(d);
		if (list == null) {
			list = new ArrayList<Integer>();
			list.add(root.data);
		} else {
			list.add(root.data);
		}
		map.put(d, list);

		verticalTraversalUtil(root.left, map, d - 1);
		verticalTraversalUtil(root.right, map, d + 1);
	}

	public static void main(String[] args) {
		VerticalTraversal tree = new VerticalTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);

		List<List<Integer>> list = tree.verticalTraversal(root);
		System.out.println(list);
	}
}