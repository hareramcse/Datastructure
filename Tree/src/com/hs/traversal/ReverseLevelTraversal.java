package com.hs.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ReverseLevelTraversal {

	/* Given a binary tree, print its nodes in reverse level order */
	void reverseLevelOrder(Node node) {
		Stack<Node> S = new Stack<Node>();
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(node);

		// Do something like normal level order traversal order.Following
		// are the differences with normal level order traversal
		// 1) Instead of printing a node, we push the node to stack
		// 2) Right subtree is visited before left subtree
		while (Q.isEmpty() == false) {
			/* Dequeue node and make it root */
			node = Q.poll();
			S.push(node);

			/* Enqueue right child */
			if (node.right != null)
				// NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
				Q.add(node.right);

			/* Enqueue left child */
			if (node.left != null)
				Q.add(node.left);
		}

		// Now pop all items from stack one by one and print them
		while (S.empty() == false) {
			node = S.pop();
			System.out.print(node.data + " ");
		}
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		ReverseLevelTraversal tree = new ReverseLevelTraversal();

		// Let us create trees shown in above diagram
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("Level Order traversal of binary tree is :");
		tree.reverseLevelOrder(root);

	}
}