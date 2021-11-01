package com.hs.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VerticalTraversal {

	private void printVerticalUtil(Node root, Map<Integer, List<Integer>> map, int d) {
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
		
		printVerticalUtil(root.left, map, d - 1);
		printVerticalUtil(root.right, map, d + 1);
	}

	private void printVertical(Node root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		printVerticalUtil(root, map, 0);

		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
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

		tree.printVertical(root);
	}
}
