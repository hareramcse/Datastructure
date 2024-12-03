package com.hs.medium;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

class RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(); // here we are taking dummy node because duplicate can start from head itself
		dummy.next = head;
		ListNode prev = dummy;

		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				prev.next = head.next;
			} else {
				prev = prev.next;
			}
			head = head.next;
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