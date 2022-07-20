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

		Node head = new Node(20);
		head.next = new Node(13);
		head.next.next = new Node(13);
		head.next.next.next = new Node(11);
		head.next.next.next.next = new Node(11);
		head.next.next.next.next.next = new Node(11);

		System.out.println("List before removal of duplicates");
		LinkedListUtil.printLinkedList(head);

		list.removeDuplicates(head);

		System.out.println("List after removal of elements");
		LinkedListUtil.printLinkedList(head);
	}
}