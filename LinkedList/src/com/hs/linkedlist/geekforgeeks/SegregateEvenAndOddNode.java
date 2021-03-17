package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

class SegregateEvenAndOddNode {

	private Node segregateEvenOdd(Node currentNode) {

		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;

		while (currentNode != null) {
			int element = currentNode.data;

			if (element % 2 == 0) {
				if (evenStart == null) {
					evenStart = currentNode;
					evenEnd = currentNode;
				} else {
					evenEnd.next = currentNode;
					evenEnd = currentNode;
				}
			} else {
				if (oddStart == null) {
					oddStart = currentNode;
					oddEnd = currentNode;
				} else {
					oddEnd.next = currentNode;
					oddEnd = currentNode;
				}
			}
			// Move current pointer one step in forward direction
			currentNode = currentNode.next;
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
