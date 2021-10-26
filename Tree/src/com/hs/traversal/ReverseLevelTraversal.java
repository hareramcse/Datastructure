package com.hs.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ReverseLevelTraversal {

	/* Given a binary tree, print its nodes in reverse level order */
	private void reverseLevelOrder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		// Do something like normal level order traversal order.
		// Following are the differences with normal level order traversal
		// 1) Instead of printing a node, we push the node to stack
		// 2) Right subtree is visited before left subtree
		while (!queue.isEmpty()) {
			/* Dequeue node and make it root */
			Node temp = queue.poll();
			stack.push(temp);

			/* Enqueue right child */
			if (temp.right != null)
				// NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
				queue.add(temp.right);

			/* Enqueue left child */
			if (temp.left != null)
				queue.add(temp.left);
		}

		// Now pop all items from stack one by one and print them
		while (stack.empty() == false) {
			Node tmp = stack.pop();
			System.out.print(tmp.data + " ");
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