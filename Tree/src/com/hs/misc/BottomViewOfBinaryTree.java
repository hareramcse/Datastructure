package com.hs.misc;

import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

	private void printBottomViewUtil(Node root, int curr, int hd, Map<Integer, int[]> map) {
		if (root == null)
			return;

		if (!map.containsKey(hd)) {
			map.put(hd, new int[] { root.data, curr });
		}

		// Compare height for already present node at similar horizontal distance
		else {
			int[] pair = map.get(hd);
			if (pair[1] <= curr) {
				pair[1] = curr;
				pair[0] = root.data;
			}
			map.put(hd, pair);
		}

		printBottomViewUtil(root.left, curr + 1, hd - 1, map);
		printBottomViewUtil(root.right, curr + 1, hd + 1, map);
	}

	private void printBottomView(Node root) {
		Map<Integer, int[]> map = new TreeMap<>();

		printBottomViewUtil(root, 0, 0, map);
		for (int val[] : map.values()) {
			System.out.print(val[0] + " ");
		}
	}

	public static void main(String[] args) {
		BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		tree.printBottomView(root);
	}
}