package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class RemoveAllOccurrencesFromList {

	// Function to remove all occurrences of duplicate elements
	public Node removeAllDuplicates(Node head) {

		// Create a dummy node that acts like a fake
		// head of list pointing to the original head
		Node dummy = new Node(0);

		// Dummy node points to the original head
		dummy.next = head;
		Node prev = dummy;
		Node current = head;

		while (current != null) {
			// Until the current and previous values are same, keep updating current
			while (current.next != null && prev.next.data == current.next.data) {
				current = current.next;
			}

			// If current has unique value i.e current
			// is not updated, Move the prev pointer to next node
			if (prev.next == current)
				prev = prev.next;

			// When current is updated to the last
			// duplicate value of that segment, make
			// prev the next of current*/
			else
				prev.next = current.next;

			current = current.next;
		}

		// Update original head to the next of dummy node
		return dummy.next;
	}

	// Driver code
	public static void main(String[] args) {
		RemoveAllOccurrencesFromList list = new RemoveAllOccurrencesFromList();
		Node head = new Node(53);
		head.next = new Node(53);
		head.next.next = new Node(49);
		head.next.next.next = new Node(49);
		head.next.next.next.next = new Node(49);
		head.next.next.next.next.next = new Node(35);
		head.next.next.next.next.next.next = new Node(28);
		head.next.next.next.next.next.next.next = new Node(23);

		System.out.println("Before removal of duplicates");
		LinkedListUtil.printLinkedList(head);

		Node removeAllDuplicates = list.removeAllDuplicates(head);

		System.out.println("\nAfter removal of duplicates");
		LinkedListUtil.printLinkedList(removeAllDuplicates);
	}
}