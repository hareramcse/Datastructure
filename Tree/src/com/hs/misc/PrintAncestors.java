package com.hs.misc;

import com.hs.tree.Node;

public class PrintAncestors {
	public boolean printAncestors(Node root, int target) {
		if (root == null)
			return false;

		if (root.data == target)
			return true;

		if (printAncestors(root.left, target) || printAncestors(root.right, target)) {
			System.out.print(root.data + " ");
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

		// print ancestors of given node
		tree.printAncestors(root, 5);
	}
}