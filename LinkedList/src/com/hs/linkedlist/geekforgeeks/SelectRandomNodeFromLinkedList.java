package com.hs.linkedlist.geekforgeeks;

import java.util.UUID;

import com.hs.basic.Node;

public class SelectRandomNodeFromLinkedList {

	// A reservoir sampling based function to print a
	// random node from a linked list
	private void printRandom(Node node) {

		// If list is empty
		if (node == null) {
			return;
		}

		// Use a different seed value so that we don't get
		// same result each time we run this program
		Math.abs(UUID.randomUUID().getMostSignificantBits());

		// Initialize result as first node
		int result = node.data;

		// Iterate from the (k+1)th element to nth element
		Node current = node;
		for (int n = 2; current != null; n++) {

			// change result with probability 1/n
			if (Math.random() % n == 0) {
				result = current.data;
			}

			// Move to next node
			current = current.next;
		}

		System.out.println("Randomly selected key is " + result);
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		SelectRandomNodeFromLinkedList list = new SelectRandomNodeFromLinkedList();
		Node head = new Node(5);
		head.next = new Node(20);
		head.next.next = new Node(4);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(30);

		list.printRandom(head);

	}
}