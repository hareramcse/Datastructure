package com.hs.construction;

import java.util.LinkedList;
import java.util.Queue;

// A linked list node
class ListNode {
	int data;
	ListNode next;

	ListNode(int d) {
		data = d;
		next = null;
	}
}

class ConstructTreeFromItsLinkedListRepresentation {
	ListNode head;
	Node root;

	// Function to insert a node at the beginning of
	// the Linked List
	void push(int new_data) {
		// allocate node and assign data
		ListNode new_node = new ListNode(new_data);

		// link the old list off the new node
		new_node.next = head;

		// move the head to point to the new node
		head = new_node;
	}

	// converts a given linked list representing a
	// complete binary tree into the linked
	// representation of binary tree.
	Node convertList2Binary(Node node) {
		// queue to store the parent nodes
		Queue<Node> q = new LinkedList<Node>();

		// Base Case
		if (head == null) {
			node = null;
			return null;
		}

		// 1.) The first node is always the root node, and
		// add it to the queue
		node = new Node(head.data);
		q.add(node);

		// advance the pointer to the next node
		head = head.next;

		// until the end of linked list is reached, do the
		// following steps
		while (head != null) {
			// 2.a) take the parent node from the q and
			// remove it from q
			Node parent = q.peek();
			q.poll();

			// 2.c) take next two nodes from the linked list.
			// We will add them as children of the current
			// parent node in step 2.b. Push them into the
			// queue so that they will be parents to the
			// future nodes
			Node leftChild = null, rightChild = null;
			leftChild = new Node(head.data);
			q.add(leftChild);
			head = head.next;
			if (head != null) {
				rightChild = new Node(head.data);
				q.add(rightChild);
				head = head.next;
			}

			// 2.b) assign the left and right children of
			// parent
			parent.left = leftChild;
			parent.right = rightChild;
		}

		return node;
	}

	// Utility function to traverse the binary tree
	// after conversion
	void inorderTraversal(Node node) {
		if (node != null) {
			inorderTraversal(node.left);
			System.out.print(node.data + " ");
			inorderTraversal(node.right);
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		ConstructTreeFromItsLinkedListRepresentation tree = new ConstructTreeFromItsLinkedListRepresentation();
		tree.push(36); /* Last node of Linked List */
		tree.push(30);
		tree.push(25);
		tree.push(15);
		tree.push(12);
		tree.push(10); /* First node of Linked List */
		Node node = tree.convertList2Binary(tree.root);

		System.out.println("Inorder Traversal of the" + " constructed Binary Tree is:");
		tree.inorderTraversal(node);
	}
}