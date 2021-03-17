package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class MoveOccurrencesElementAtEndOfList {

	// Moves all occurrences of given key to end of linked list.
	private void moveToEnd(Node head, int key) {
		// Keeps track of locations where key is present.
		Node pKey = head;

		// Traverse list
		Node pCrawl = head;
		while (pCrawl != null) {
			// If current pointer is not same as pointer
			// to a key location, then we must have found
			// a key in linked list. We swap data of pCrawl
			// and pKey and move pKey to next position.
			if (pCrawl != pKey && pCrawl.data != key) {
				pKey.data = pCrawl.data;
				pCrawl.data = key;
				pKey = pKey.next;
			}

			// Find next position where key is present
			if (pKey.data != key)
				pKey = pKey.next;

			// Moving to next Node
			pCrawl = pCrawl.next;
		}
	}

	public static void main(String args[]) {
		MoveOccurrencesElementAtEndOfList list = new MoveOccurrencesElementAtEndOfList();
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(10);
		head.next.next.next = new Node(30);
		head.next.next.next.next = new Node(40);
		head.next.next.next.next.next = new Node(10);
		head.next.next.next.next.next.next = new Node(60);

		System.out.printf("Before moveToEnd(), the Linked list is\n");
		LinkedListUtil.printLinkedList(head);

		int key = 10;
		list.moveToEnd(head, key);

		System.out.printf("\nAfter moveToEnd(), the Linked list is\n");
		LinkedListUtil.printLinkedList(head);
	}
}