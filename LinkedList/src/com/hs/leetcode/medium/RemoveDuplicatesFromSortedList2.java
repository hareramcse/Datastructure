package com.hs.leetcode.medium;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

class RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode prev = dummy;
		ListNode current = head;

		while (current != null && current.next != null) {
			boolean foundDuplicate = false;
			while (current != null && current.next != null && current.val == current.next.val) {
				foundDuplicate = true;
				current = current.next;
			}

			if (foundDuplicate) {
				prev.next = current.next;
			} else {
				prev = prev.next;
			}
			current = current.next;
		}
		return dummy.next;
	}

	public static void main(String args[]) {
		RemoveDuplicatesFromSortedList2 list = new RemoveDuplicatesFromSortedList2();

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