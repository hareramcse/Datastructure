package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

class SegregateEvenAndOddNode {

	Node head;

	private void segregateEvenOdd(Node currentNode) {

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
			return;
		}
		evenEnd.next = oddStart;
		oddEnd.next = null;
		head = evenStart;
	}

	private void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		SegregateEvenAndOddNode llist = new SegregateEvenAndOddNode();
		llist.push(11);
		llist.push(10);
		llist.push(9);
		llist.push(6);
		llist.push(4);
		llist.push(1);
		llist.push(0);
		System.out.println("Origional Linked List");
		llist.printList();

		llist.segregateEvenOdd(llist.head);

		System.out.println("Modified Linked List");
		llist.printList();
	}
}
