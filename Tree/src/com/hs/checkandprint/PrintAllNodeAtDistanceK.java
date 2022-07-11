package com.hs.checkandprint;

import com.hs.tree.Node;

class PrintAllNodeAtDistanceK {

	private void printKDistant(Node root, int k) {
		if (root == null)
			return;

		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		printKDistant(root.left, k - 1);
		printKDistant(root.right, k - 1);
	}

	public static void main(String args[]) {
		PrintAllNodeAtDistanceK tree = new PrintAllNodeAtDistanceK();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);

		tree.printKDistant(root, 2);
	}
}
