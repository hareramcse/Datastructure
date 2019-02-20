package com.hs.traversal;

public class InOrderSuccessor {
	Node root;

	// to change previous node
	static class PreviousNode {
		Node pNode;

		PreviousNode() {
			pNode = null;
		}
	}

	// function to find inorder successor of a node
	private void inOrderSuccessorOfBinaryTree(Node root, PreviousNode pre, int searchNode) {
		// Case1: If right child is not NULL
		if (root.right != null)
			inOrderSuccessorOfBinaryTree(root.right, pre, searchNode);

		// Case2: If root data is equal to search node
		if (root.data == searchNode)
			System.out.println(
					"inorder successor of " + searchNode + " is: " + (pre.pNode != null ? pre.pNode.data : "null"));
		pre.pNode = root;

		if (root.left != null)
			inOrderSuccessorOfBinaryTree(root.left, pre, searchNode);
	}

	public static void main(String[] args) {
		InOrderSuccessor tree = new InOrderSuccessor();

		// Let's construct the binary tree
		// as shown in above diagram
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);

		// Case 1
		tree.inOrderSuccessorOfBinaryTree(tree.root, new PreviousNode(), 3);

		// Case 2
		tree.inOrderSuccessorOfBinaryTree(tree.root, new PreviousNode(), 4);

		// Case 3
		tree.inOrderSuccessorOfBinaryTree(tree.root, new PreviousNode(), 6);
	}
}