package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class reverseBlockOfKNodes {

	private Node reverseKNodes(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;
		int count = k;

		while (current != null && count > 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count--;
		}

		if (next != null) {
			head.next = reverseKNodes(next, k);
		}
		return prev;
	}

	public static void main(String[] args) {
		reverseBlockOfKNodes list = new reverseBlockOfKNodes();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(20);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(25);
		head.next.next.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next.next.next = new Node(60);

		Node rev = list.reverseKNodes(head, 2);
		LinkedListUtil.printLinkedList(rev);
	}
}
