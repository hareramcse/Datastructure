package com.hs.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromUnsortedList {

	private void removeDuplicate(Node head) {
		// Hash to store seen values
		Set<Integer> hs = new HashSet<>();

		/* Pick elements one by one */
		Node current = head;
		Node prev = null;
		while (current != null) {
			int curval = current.data;

			// If current value is seen before
			if (hs.contains(curval)) {
				prev.next = current.next;
			} else {
				hs.add(curval);
				prev = current;
			}
			current = current.next;
		}
	}

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		/*
		 * The constructed linked list is: 10->12->11->11->12->11->10
		 */
		RemoveDuplicateFromUnsortedList list = new RemoveDuplicateFromUnsortedList();
		Node head = new Node(10);
		head.next = new Node(12);
		head.next.next = new Node(11);
		head.next.next.next = new Node(11);
		head.next.next.next.next = new Node(12);
		head.next.next.next.next.next = new Node(11);
		head.next.next.next.next.next.next = new Node(10);

		System.out.println("Linked list before removing duplicates :");
		list.printList(head);

		list.removeDuplicate(head);

		System.out.println("\nLinked list after removing duplicates :");
		list.printList(head);
	}
}