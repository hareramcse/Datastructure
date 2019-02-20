package com.hs.bst;

public class InOrderSuccessorOfBST {

	public Node inOrderSuccessor(Node root, Node k) {
		// step 1 of the above algorithm
		if (k.right != null)
			return findMinNode(k.right);

		Node successor = null;

		// Start from root and search for successor down the tree
		while (root != null) {
			if (k.data < root.data) {
				successor = root;
				root = root.left;
			} else if (k.data > root.data)
				root = root.right;
			else
				break;
		}

		return successor;
	}

	Node findMinNode(Node root) {
		if (root == null)
			return root;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static void main(String[] args) {
		InOrderSuccessorOfBST tree = new InOrderSuccessorOfBST();
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);

		Node temp = root.left.right;

		System.out.println(tree.inOrderSuccessor(root, temp).data);
	}
}