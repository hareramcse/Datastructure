package com.hs.construction;

import java.util.LinkedList;
import java.util.Queue;

import com.hs.tree.Node;

class ListNode {
	int data;
	ListNode next;

	ListNode(int d) {
		data = d;
		next = null;
	}
}

// O(n)
public class ConstructTreeFromLinkedList {
	private ListNode head;

	public Node convertListToBinaryTree(ListNode head) {
		// base case
		if (head == null) {
			return null;
		}

		// create the root using the first node of the linked list
		Node root = new Node(head.data);

		// move the head pointer to the next node
		head = head.next;

		// create a queue to store tree pointers and enqueue the root node
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		// loop till the end of the linked list is reached
		while (head != null) {
			Node front = q.poll();

			// create a left child from the next node in the linked list and enqueue it
			front.left = new Node(head.data);
			q.add(front.left);

			// move the head pointer to the next node
			head = head.next;

			// if the linked list did not reach its end
			if (head != null) {
				// create the right child from the next node in the linked list and
				// enqueue it
				front.right = new Node(head.data);
				q.add(front.right);

				// move the head pointer to the next node
				head = head.next;
			}
		}

		// return root of the constructed binary tree
		return root;
	}

	// Function to insert a node at the beginning of the Linked List
	private void push(int new_data) {
		ListNode newNode = new ListNode(new_data);
		newNode.next = head;
		head = newNode;
	}

	// Utility function to traverse the binary tree after conversion
	private void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	public static void main(String[] args) {
		ConstructTreeFromLinkedList tree = new ConstructTreeFromLinkedList();
		tree.push(36); /* Last node of Linked List */
		tree.push(30);
		tree.push(25);
		tree.push(15);
		tree.push(12);
		tree.push(10); /* First node of Linked List */

		Node node = tree.convertListToBinaryTree(tree.head);

		System.out.println("Inorder Traversal of the constructed Binary Tree is:");
		tree.inorderTraversal(node);
	}
}