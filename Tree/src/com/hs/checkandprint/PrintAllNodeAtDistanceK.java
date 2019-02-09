package com.hs.checkandprint;

class PrintAllNodeAtDistanceK {

	void printKDistant(Node node, int k) {
		if (node == null)
			return;
		if (k == 0) {
			System.out.print(node.data + " ");
			return;
		} else {
			printKDistant(node.left, k - 1);
			printKDistant(node.right, k - 1);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		PrintAllNodeAtDistanceK tree = new PrintAllNodeAtDistanceK();

		/*
		 * Constructed binary tree is 1 / \ 2 3 / \ / 4 5 8
		 */
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);

		tree.printKDistant(root, 2);
	}
}
