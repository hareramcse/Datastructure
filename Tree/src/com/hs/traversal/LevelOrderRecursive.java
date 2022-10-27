package com.hs.traversal;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

class LevelOrderRecursive {
	public List<List<Integer>> levelOrderTraversal(Node root) {
		int h = height(root);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 1; i <= h; i++) {
			List<Integer> list = new ArrayList<>();
			printGivenLevel(root, i, list);
			result.add(list);
		}
		return result;
	}

	private int height(Node root) {
		if (root == null)
			return 0;

		int lHeight = height(root.left);
		int rHeight = height(root.right);

		return 1 + Math.max(lHeight, rHeight);
	}

	private void printGivenLevel(Node root, int level, List<Integer> list) {
		if (root == null)
			return;

		if (level == 1)
			list.add(root.data);

		if (level > 1) {
			printGivenLevel(root.left, level - 1, list);
			printGivenLevel(root.right, level - 1, list);
		}
	}

	public static void main(String args[]) {
		LevelOrderRecursive tree = new LevelOrderRecursive();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);

		System.out.println("Level order traversal of binary tree is ");
		List<List<Integer>> result = tree.levelOrderTraversal(root);
		System.out.println(result);
	}
}