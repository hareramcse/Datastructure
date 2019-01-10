package com.hs.traversal;

import java.util.Stack;

public class InorderTraversal {

	Node root;

	void inorder() {
		if (root == null) {
			return;
		}

		// keep the nodes in the path that are waiting to be visited
		Stack<Node> stack = new Stack<Node>();
		Node temp = root;

		// first node to be visited will be the left one
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}

		// traverse the tree
		while (stack.size() > 0) {

			// pop the stack which will be the last left node of the tree.
			temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				temp = temp.right;

				// the next node to be visited is the leftmost
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		InorderTraversal tree = new InorderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.inorder();
	}
}
