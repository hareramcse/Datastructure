package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

class SegregateEvenAndOddNode {

	private Node segregateEvenOdd(Node head) {

		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;

		while (head != null) {
			int data = head.data;

			if (data % 2 == 0) {
				if (evenStart == null) {
					evenStart = head;
					evenEnd = head;
				} else {
					evenEnd.next = head;
					evenEnd = head;
				}
			} else {
				if (oddStart == null) {
					oddStart = head;
					oddEnd = head;
				} else {
					oddEnd.next = head;
					oddEnd = head;
				}
			}
			// Move current pointer one step in forward direction
			head = head.next;
		}

		if (oddStart == null || evenStart == null) {
			return null;
		}
		evenEnd.next = oddStart;
		oddEnd.next = null;
		return evenStart;
	}

	public static void main(String args[]) {
		SegregateEvenAndOddNode list = new SegregateEvenAndOddNode();

		Node head = LinkedListUtil.addLast(null, 11);
		head = LinkedListUtil.addLast(head, 10);
		head = LinkedListUtil.addLast(head, 9);
		head = LinkedListUtil.addLast(head, 6);
		head = LinkedListUtil.addLast(head, 4);
		head = LinkedListUtil.addLast(head, 1);
		head = LinkedListUtil.addLast(head, 0);

		System.out.println("Origional Linked List");
		LinkedListUtil.printLinkedList(head);

		head = list.segregateEvenOdd(head);

		System.out.println("Modified Linked List");
		LinkedListUtil.printLinkedList(head);
	}
}
