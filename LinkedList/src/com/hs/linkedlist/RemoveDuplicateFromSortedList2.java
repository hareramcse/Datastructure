package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 82. Remove Duplicates from Sorted List II
class RemoveDuplicateFromSortedList2 {

	public Node removeDuplicates(Node head) {
		if (head == null || head.next == null)
			return head;

		Node dummy = new Node();
		dummy.next = head;
		Node pre = dummy;
		Node current = head;

		while (current != null) {
			if (current.next != null && current.data == current.next.data) {
				while (current.next != null && current.data == current.next.data) {
					current = current.next;
				}
				pre.next = current.next;
			} else {
				pre = current;
			}
			current = current.next;
		}
		return dummy.next;
	}

	public static void main(String args[]) {
		RemoveDuplicateFromSortedList2 list = new RemoveDuplicateFromSortedList2();

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