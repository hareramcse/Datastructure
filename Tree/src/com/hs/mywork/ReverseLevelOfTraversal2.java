package com.hs.mywork;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOfTraversal2 {

	static Node root;

	/* Given a binary tree, print its nodes in reverse level order */
	void reverseLevelOrder(Node node) {
		Stack<Node> S = new Stack();
		Queue<Node> Q = new LinkedList();
		Q.add(node);

		// Do something like normal level order traversal order. Following are
		// the differences with normal level order traversal
		// 1) Instead of printing a node, we push the node to stack
		// 2) Right subtree is visited before left subtree
		while (Q.isEmpty() == false) {

			/* Dequeue node and make it root */
			node = Q.peek();
			Q.remove();
			S.push(node);

			/* Enqueue right child */
			if (node.right != null) {
				Q.add(node.right); // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
			}
			/* Enqueue left child */
			if (node.left != null) {
				Q.add(node.left);
			}
		}

		// Now pop all items from stack one by one and print them
		while (S.empty() == false) {
			node = S.peek();
			System.out.print(node.data + " ");
			S.pop();
		}
	}

	// Driver program to test above functions
	public static void main(String args[]) {

		ReverseLevelOfTraversal2 tree = new ReverseLevelOfTraversal2();

		// Let us create trees shown in above diagram
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("Level Order traversal of binary tree is : ");
		tree.reverseLevelOrder(root);

	}
}
