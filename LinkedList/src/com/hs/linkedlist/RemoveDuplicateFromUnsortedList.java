package com.hs.linkedlist;

import java.util.HashSet;

public class RemoveDuplicateFromUnsortedList {
	Node head;

	/*
	 * Function to remove duplicates from a unsorted linked list
	 */
	void removeDuplicate(Node head) {
		// Hash to store seen values
		HashSet<Integer> hs = new HashSet<>();

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

	/* Function to print nodes in a given linked list */
	void printList(Node head) {
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
		list.head = new Node(10);
		list.head.next = new Node(12);
		list.head.next.next = new Node(11);
		list.head.next.next.next = new Node(11);
		list.head.next.next.next.next = new Node(12);
		list.head.next.next.next.next.next = new Node(11);
		list.head.next.next.next.next.next.next = new Node(10);

		System.out.println("Linked list before removing duplicates :");
		list.printList(list.head);

		list.removeDuplicate(list.head);

		System.out.println("\nLinked list after removing duplicates :");
		list.printList(list.head);
	}
}