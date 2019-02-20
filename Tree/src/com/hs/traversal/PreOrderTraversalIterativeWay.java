package com.hs.traversal;

import java.util.Stack;

class PreOrderTraversalIterativeWay {

	// An iterative process to print preorder traversal of Binary tree
	void iterativePreorder(Node root) {

		// Base Case
		if (root == null) {
			return;
		}

		// Create an empty stack and push root to it
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item a) print it b)
		 * push its right child c) push its left child Note that right child is pushed
		 * first so that left is processed first
		 */
		while (nodeStack.empty() == false) {

			// Pop the top item from stack and print it
			Node mynode = nodeStack.peek();
			System.out.print(mynode.data + " ");
			nodeStack.pop();

			// Push right and left children of the popped node to stack
			if (mynode.right != null) {
				nodeStack.push(mynode.right);
			}
			if (mynode.left != null) {
				nodeStack.push(mynode.left);
			}
		}
	}

	// driver program to test above functions
	public static void main(String args[]) {
		PreOrderTraversalIterativeWay tree = new PreOrderTraversalIterativeWay();
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);
		tree.iterativePreorder(root);

	}
}