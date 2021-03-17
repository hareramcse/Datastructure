package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class AddOneToLinkedList {
	// carry after all nodes are processed.
	private int addWithCarry(Node head) {

		// If linked list is empty, then return carry
		if (head == null)
			return 1;

		// Add carry returned be next node call
		int res = head.data + addWithCarry(head.next);

		// Update data and return new carry
		head.data = res % 10;
		return res / 10;
	}

	// This function mainly uses addWithCarry().
	private Node addOne(Node head) {

		// Add 1 to linked list from end to beginning
		int carry = addWithCarry(head);

		// If there is carry after processing all nodes,
		// then we need to add a new node to linked list
		if (carry > 0) {
			Node newNode = new Node(carry);
			newNode.next = head;
			return newNode; // New node becomes head now
		}

		return head;
	}

	public static void main(String[] args) {
		AddOneToLinkedList list = new AddOneToLinkedList();
		Node head = new Node(1);
		head.next = new Node(9);
		head.next.next = new Node(9);
		head.next.next.next = new Node(9);

		System.out.print("List is ");
		LinkedListUtil.printLinkedList(head);

		head = list.addOne(head);
		System.out.println();
		System.out.print("Resultant list is ");
		LinkedListUtil.printLinkedList(head);
	}
}