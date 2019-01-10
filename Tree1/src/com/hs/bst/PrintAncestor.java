package com.hs.bst;

public class PrintAncestor {
	Node root;

	/*
	 * If data is present in tree, then prints the ancestors and returns true,
	 * otherwise returns false.
	 */
	boolean printAncestors(Node node, int data) {
		/* base cases */
		if (node == null)
			return false;

		if (node.data == data)
			return true;

		/*
		 * If data is present in either left or right subtree of this node, then print
		 * this node
		 */
		if (printAncestors(node.left, data) || printAncestors(node.right, data)) {
			System.out.print(node.data + " ");
			return true;
		}

		/* Else return false */
		return false;
	}

	public static void main(String[] args) {
		PrintAncestor tree = new PrintAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(7);
		tree.printAncestors(tree.root, 7);
	}
}
