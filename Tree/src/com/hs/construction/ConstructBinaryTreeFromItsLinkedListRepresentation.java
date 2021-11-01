package com.hs.construction;

import java.util.LinkedList;
import java.util.Queue;

class ListNode {
	int data;
	ListNode next;

	ListNode(int d) {
		data = d;
		next = null;
	}
}

/*
 * We are mainly given level order traversal in sequential access form. We know
 * head of linked list is always is root of the tree. We take the first node as
 * root and we also know that the next two nodes are left and right children of
 * root. So we know partial Binary Tree. The idea is to do Level order traversal
 * of the partially built Binary Tree using queue and traverse the linked list
 * at the same time. At every step, we take the parent node from queue, make
 * next two nodes of linked list as children of the parent node, and enqueue the
 * next two nodes to queue.
 */
// O(n)
public class ConstructBinaryTreeFromItsLinkedListRepresentation {
	private ListNode head;

	// Function to insert a node at the beginning of the Linked List
	private void push(int new_data) {
		ListNode new_node = new ListNode(new_data);
		new_node.next = head;
		head = new_node;
	}

	// converts a given linked list representing a complete binary tree into the
	// linked representation of binary tree.
	private Node convertListToBinaryTree(Node root) {
		// queue to store the parent nodes
		Queue<Node> queue = new LinkedList<Node>();

		// Base Case
		if (head == null) {
			root = null;
			return null;
		}

		// 1.) The first node is always the root node, add it to the queue
		root = new Node(head.data);
		queue.add(root);

		// advance the pointer to the next node
		head = head.next;

		// until the end of linked list is reached, do the following steps
		while (head != null) {
			// a) take the parent node from the queue and remove it from queue
			Node parent = queue.peek();
			queue.poll();

			// b) take next two nodes from the linked list.
			// We will add them as children of the current
			// parent node in step

			// c) Push them into the queue so that they will be parents to the
			// future nodes
			Node leftChild = null, rightChild = null;
			leftChild = new Node(head.data);
			queue.add(leftChild);
			head = head.next;
			if (head != null) {
				rightChild = new Node(head.data);
				queue.add(rightChild);
				head = head.next;
			}

			// d) assign the left and right children of parent
			parent.left = leftChild;
			parent.right = rightChild;
		}

		return root;
	}

	// Utility function to traverse the binary tree after conversion
	private void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		ConstructBinaryTreeFromItsLinkedListRepresentation tree = new ConstructBinaryTreeFromItsLinkedListRepresentation();
		tree.push(36); /* Last node of Linked List */
		tree.push(30);
		tree.push(25);
		tree.push(15);
		tree.push(12);
		tree.push(10); /* First node of Linked List */
		Node root = null;

		Node node = tree.convertListToBinaryTree(root);

		System.out.println("Inorder Traversal of the constructed Binary Tree is:");
		tree.inorderTraversal(node);
	}
}