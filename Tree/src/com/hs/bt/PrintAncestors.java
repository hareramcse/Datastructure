package com.hs.bt;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

public class PrintAncestors {
	public List<Integer> printAncestors(Node root, int target) {
		List<Integer> result = new ArrayList<>();
		ancestors(root, target, result);
		return result;
	}

	private boolean ancestors(Node root, int target, List<Integer> result) {
		if (root == null)
			return false;

		if (root.data == target)
			return true;

		boolean left = ancestors(root.left, target, result);
		boolean right = ancestors(root.right, target, result);
		if (left || right) {
			result.add(root.data);
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		PrintAncestors tree = new PrintAncestors();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		List<Integer> result = tree.printAncestors(root, 5);
		System.out.println(result);
	}
}