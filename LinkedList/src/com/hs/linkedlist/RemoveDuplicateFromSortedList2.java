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
				// skip the nodes whose values are equal to current node
				while (current.next != null && current.data == current.next.data) {
					current = current.next;
				}
				pre.next = current.next;
			} else {
				pre = pre.next;
			}
			current = current.next;
		}
		return dummy.next;
	}

	public static void main(String args[]) {
		RemoveDuplicateFromSortedList2 list = new RemoveDuplicateFromSortedList2();

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