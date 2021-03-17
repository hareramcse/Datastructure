package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

class RemoveDuplicateFromSortedList {

	private void removeDuplicates(Node head) {
		/* Another reference to head */
		Node current = head;

		/* Pointer to store the next pointer of a node to be deleted */
		Node next_next;

		/* do nothing if the list is empty */
		if (head == null)
			return;

		/* Traverse list till the last node */
		while (current.next != null) {

			/* Compare current node with the next node */
			if (current.data == current.next.data) {
				next_next = current.next.next;
				current.next = null;
				current.next = next_next;
			} else // advance if no deletion
				current = current.next;
		}
	}

	public static void main(String args[]) {
		RemoveDuplicateFromSortedList list = new RemoveDuplicateFromSortedList();

		Node head = LinkedListUtil.addLast(null, 20);
		head = LinkedListUtil.addLast(head, 13);
		head = LinkedListUtil.addLast(head, 13);
		head = LinkedListUtil.addLast(head, 11);
		head = LinkedListUtil.addLast(head, 11);
		head = LinkedListUtil.addLast(head, 11);

		System.out.println("List before removal of duplicates");
		LinkedListUtil.printLinkedList(head);

		list.removeDuplicates(head);

		System.out.println("List after removal of elements");
		LinkedListUtil.printLinkedList(head);
	}
}