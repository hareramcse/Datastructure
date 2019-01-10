package com.hs.random;

public class PrintNodeAtKthDistanceFromRoot {

	static Node root;

	void printKDistant(Node node, int k) {
		if (node == null) {
			return;
		}
		if (k == 0) {
			System.out.print(node.data + " ");
			return;
		} else {
			printKDistant(node.left, k - 1);
			printKDistant(node.right, k - 1);
		}
	}

	public static void main(String args[]) {
		PrintNodeAtKthDistanceFromRoot tree = new PrintNodeAtKthDistanceFromRoot();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);

		tree.printKDistant(root, 2);
	}
}
