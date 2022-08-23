package com.hs.leetcode.easy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

class RemoveDuplicatesFromSortedList1 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String args[]) {
		RemoveDuplicatesFromSortedList1 list = new RemoveDuplicatesFromSortedList1();

		ListNode head = new ListNode(20);
		head.next = new ListNode(13);
		head.next.next = new ListNode(13);
		head.next.next.next = new ListNode(11);
		head.next.next.next.next = new ListNode(11);
		head.next.next.next.next.next = new ListNode(11);

		System.out.println("List before removal of duplicates");
		LinkedListUtil.printLinkedList(head);

		list.deleteDuplicates(head);

		System.out.println("List after removal of elements");
		LinkedListUtil.printLinkedList(head);
	}
}