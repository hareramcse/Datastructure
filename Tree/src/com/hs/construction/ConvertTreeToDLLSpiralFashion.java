package com.hs.construction;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ConvertTreeToDLLSpiralFashion {
	Node head;

	/*
	 * Given a reference to a node, inserts the node on the front of the list.
	 */
	void push(Node node) {
		// Make right of given node as head and left as
		// NULL
		node.right = head;
		node.left = null;

		// change left of head node to given node
		if (head != null)
			head.left = node;

		// move the head to point to the given node
		head = node;
	}

	// Function to prints contents of DLL
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

	/* Function to print corner node at each level */
	void spiralLevelOrder(Node root) {
		// Base Case
		if (root == null)
			return;

		// Create an empty deque for doing spiral
		// level order traversal and enqueue root
		Deque<Node> q = new LinkedList<Node>();
		q.addFirst(root);

		// create a stack to store Binary Tree nodes
		// to insert into DLL later
		Stack<Node> stk = new Stack<Node>();

		int level = 0;
		while (!q.isEmpty()) {
			// nodeCount indicates number of Nodes
			// at current level.
			int nodeCount = q.size();

			// Dequeue all Nodes of current level and
			// Enqueue all Nodes of next level
			if ((level & 1) % 2 != 0) // odd level
			{
				while (nodeCount > 0) {
					// dequeue node from front & push it to
					// stack
					Node node = q.peekFirst();
					q.pollFirst();
					stk.push(node);

					// insert its left and right children
					// in the back of the deque
					if (node.left != null)
						q.addLast(node.left);
					if (node.right != null)
						q.addLast(node.right);

					nodeCount--;
				}
			} else // even level
			{
				while (nodeCount > 0) {
					// dequeue node from the back & push it
					// to stack
					Node node = q.peekLast();
					q.pollLast();
					stk.push(node);

					// inserts its right and left children
					// in the front of the deque
					if (node.right != null)
						q.addFirst(node.right);
					if (node.left != null)
						q.addFirst(node.left);
					nodeCount--;
				}
			}
			level++;
		}

		// pop all nodes from stack and
		// push them in the beginning of the list
		while (!stk.empty()) {
			push(stk.peek());
			stk.pop();
		}

		System.out.println("Created DLL is : ");
		printList(head);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		// Let us create binary tree as shown in above diagram
		ConvertTreeToDLLSpiralFashion tree = new ConvertTreeToDLLSpiralFashion();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		// root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		// root.right.right.right = new Node(15);

		tree.spiralLevelOrder(root);
	}
}
