package com.hs.linkedlist.madeeasy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class ReverseLinkedListInPairsWithIterative {

	private void reverseListInPairs(Node head) {
		Node temp = head;
		while (temp != null && temp.next != null) {
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedListInPairsWithIterative list = new ReverseLinkedListInPairsWithIterative();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(20);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(25);
		head.next.next.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next.next.next = new Node(60);

		list.reverseListInPairs(head);
		LinkedListUtil.printLinkedList(head);
	}
}
