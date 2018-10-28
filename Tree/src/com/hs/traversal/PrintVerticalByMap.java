package com.hs.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class PrintVerticalByMap {
	Node root;

	void printVerticalUtil(Node root, Map<Integer, List<Integer>> map, int hd) {
		if (root == null)
			return;
		
		List<Integer> list = map.get(hd);
		if (list == null) {
			list = new ArrayList<Integer>();
			list.add(root.data);
		} else {
			list.add(root.data);
		}
		
		map.put(hd, list);
		
		printVerticalUtil(root.left, map, hd - 1);
		printVerticalUtil(root.right, map, hd + 1);
	}

	void printVertical(Node root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		printVerticalUtil(root, map, 0);

		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		PrintVerticalByMap tree = new PrintVerticalByMap();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		tree.printVertical(tree.root);
	}
}
