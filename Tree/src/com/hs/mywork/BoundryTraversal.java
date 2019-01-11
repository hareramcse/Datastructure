package com.hs.mywork;

public class BoundryTraversal {
	Node root;

	void printLeaves(Node root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		}
		printLeaves(root.left);
		printLeaves(root.right);
	}

	void printLeftBoundry(Node root) {
		if (root != null) {
			if (root.left != null) {
				System.out.println(root.data);
				printLeftBoundry(root.left);
			}
		}
	}

	void printRightBoundry(Node root) {
		if (root != null) {
			if (root.right != null) {
				System.out.println(root.data);
				printLeftBoundry(root.right);
			}
		}
	}

	void printBoundry(Node root) {
		System.out.println(root.data);
		printLeftBoundry(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRightBoundry(root.right);
	}

	public static void main(String[] args) {
		BoundryTraversal tree = new BoundryTraversal();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);

		BoundryTraversal bt = new BoundryTraversal();
		bt.printBoundry(tree.root);
	}
}
