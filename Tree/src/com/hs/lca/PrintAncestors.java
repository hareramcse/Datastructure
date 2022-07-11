package com.hs.lca;

import com.hs.tree.Node;

public class PrintAncestors {

	private boolean printAncestors(Node node, int target) {
		if (node == null)
			return false;

		if (node.data == target)
			return true;

		if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
			System.out.print(node.data + " ");
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