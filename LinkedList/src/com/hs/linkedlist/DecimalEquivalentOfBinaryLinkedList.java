package com.hs.linkedlist;

import com.hs.basic.Node;

public class DecimalEquivalentOfBinaryLinkedList {

	// Returns decimal value of binary linked list
	private int decimalValue(Node head) {
		// Initialized result
		int res = 0;

		// Traverse linked list
		while (head != null) {
			// Multiply result by 2 and add head's data
			res = (res << 1) + head.data;
			head = head.next;
		}
		return res;
	}

	public static void main(String args[]) {
		DecimalEquivalentOfBinaryLinkedList list = new DecimalEquivalentOfBinaryLinkedList();
		Node head = new Node(1);
		head.next = new Node(0);
		head.next.next = new Node(1);
		head.next.next.next = new Node(1);

		System.out.print("Decimal value is " + list.decimalValue(head));
	}
}
