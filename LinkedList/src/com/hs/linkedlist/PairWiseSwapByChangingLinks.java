package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class PairWiseSwapByChangingLinks {

	private Node pairWiseSwap(Node head) {

		// Base Case: The list is empty or has only one node
		if (head == null || head.next == null) {
			return head;
		}

		// Store head of list after two nodes
		Node remaing = head.next.next;

		// Change head
		Node newHead = head.next;

		// Change next of second node
		head.next.next = head;

		// Recur for remaining list and change next of head
		head.next = pairWiseSwap(remaing);

		// Return new head of modified list
		return newHead;
	}

	public static void main(String[] args) {
		PairWiseSwapByChangingLinks list = new PairWiseSwapByChangingLinks();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

		System.out.println("Linked list before calling pairwiseSwap() ");
		LinkedListUtil.printLinkedList(head);
		head = list.pairWiseSwap(head);
		System.out.println("");
		System.out.println("Linked list after calling pairwiseSwap() ");
		LinkedListUtil.printLinkedList(head);
		System.out.println("");
	}
}