package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 24. Swap Nodes in Pairs Leetcode
public class ReverseLinkedListInPairs {

	public Node pairWiseSwap(Node head) {

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
		ReverseLinkedListInPairs list = new ReverseLinkedListInPairs();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(40);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(25);
		head.next.next.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next.next.next = new Node(60);

		Node reverseList = list.pairWiseSwap(head);
		LinkedListUtil.printLinkedList(reverseList);
	}
}