package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 83. Remove Duplicates from Sorted List Leetcode
class RemoveDuplicateFromSortedList1 {

	public Node removeDuplicates(Node head) {
		Node current = head;
		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String args[]) {
		RemoveDuplicateFromSortedList1 list = new RemoveDuplicateFromSortedList1();

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