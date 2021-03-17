package com.hs.linkedlist.geekforgeeks;

import java.util.HashSet;
import java.util.Set;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class RemoveDuplicateFromUnsortedList {

	private void removeDuplicate(Node head) {
		Set<Integer> set = new HashSet<>();

		/* Pick elements one by one */
		Node current = head;
		Node prev = null;
		while (current != null) {
			int curval = current.data;

			// If current value is seen before
			if (set.contains(curval)) {
				prev.next = current.next;
			} else {
				set.add(curval);
				prev = current;
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicateFromUnsortedList list = new RemoveDuplicateFromUnsortedList();
		Node head = new Node(10);
		head.next = new Node(12);
		head.next.next = new Node(11);
		head.next.next.next = new Node(11);
		head.next.next.next.next = new Node(12);
		head.next.next.next.next.next = new Node(11);
		head.next.next.next.next.next.next = new Node(10);

		System.out.println("Linked list before removing duplicates :");
		LinkedListUtil.printLinkedList(head);

		list.removeDuplicate(head);

		System.out.println("\nLinked list after removing duplicates :");
		LinkedListUtil.printLinkedList(head);
	}
}