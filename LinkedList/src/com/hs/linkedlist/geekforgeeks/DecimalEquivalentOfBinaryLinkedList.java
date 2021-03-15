package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

public class DecimalEquivalentOfBinaryLinkedList {

	// Returns decimal value of binary linked list /
	private int decimalValue(Node head) {
		// Initialized result
		int res = 0;

		// Traverse linked list
		while (head != null) {
			// Multiply result by 2 and add head's data
			res = (res << 1) + head.data;

			// Move next
			head = head.next;
		}
		return res;
	}

	// Driver code/
	public static void main(String args[]) {
		DecimalEquivalentOfBinaryLinkedList list = new DecimalEquivalentOfBinaryLinkedList();
		// Start with the empty list /
		Node head = new Node(1);
		head.next = new Node(0);
		head.next.next = new Node(1);
		head.next.next.next = new Node(1);

		System.out.print("Decimal value is " + list.decimalValue(head));
	}
}
