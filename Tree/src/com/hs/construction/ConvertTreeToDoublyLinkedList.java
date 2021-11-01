package com.hs.construction;

/*
 * In the following implementation, we traverse the tree in inorder fashion. 
 * We add nodes at the beginning of current linked list and update head of the 
 * list using pointer to head pointer. Since we insert at the beginning, 
 * we need to process leaves in reverse order. For reverse order, 
 * we first traverse the right subtree before the left sub 
 * i.e. do a reverse inorder traversal.
 */
public class ConvertTreeToDoublyLinkedList {

	// 'head' reference to head node of created double linked list
	private Node head;

	// A simple recursive function to convert a given
	// Binary tree to Doubly Linked List
	private void binaryTreeToDoublyLinkedList(Node root) {
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		binaryTreeToDoublyLinkedList(root.right);

		// insert root into DLL
		root.right = head;

		// Change left pointer of previous head
		if (head != null)
			head.left = root;

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		binaryTreeToDoublyLinkedList(root.left);
	}

	/* Function to print nodes in a given doubly linked list */
	private void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		ConvertTreeToDoublyLinkedList tree = new ConvertTreeToDoublyLinkedList();

		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.right = new Node(4);
		root.left.left = new Node(1);
		root.right.right = new Node(8);
		root.left.left.right = new Node(2);
		root.left.left.left = new Node(0);
		root.right.right.left = new Node(7);
		root.right.right.right = new Node(9);

		tree.binaryTreeToDoublyLinkedList(root);
		tree.printList(tree.head);
	}
}
