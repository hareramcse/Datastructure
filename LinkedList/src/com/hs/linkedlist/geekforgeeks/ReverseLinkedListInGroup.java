package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class ReverseLinkedListInGroup {

	Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting
		 * from current. And make rest of the list as next of first node
		 */
		if (next != null)
			head.next = reverse(next, k);

		// prev is now head of input list
		return prev;
	}

	public static void main(String args[]) {
		ReverseLinkedListInGroup list = new ReverseLinkedListInGroup();

		Node head = LinkedListUtil.addLast(null, 9);
		head = LinkedListUtil.addLast(head, 8);
		head = LinkedListUtil.addLast(head, 7);
		head = LinkedListUtil.addLast(head, 6);
		head = LinkedListUtil.addLast(head, 5);
		head = LinkedListUtil.addLast(head, 4);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 2);
		head = LinkedListUtil.addLast(head, 1);

		System.out.println("Given Linked List");
		LinkedListUtil.printLinkedList(head);

		head = list.reverse(head, 3);

		System.out.println("Reversed list");
		LinkedListUtil.printLinkedList(head);
	}
}