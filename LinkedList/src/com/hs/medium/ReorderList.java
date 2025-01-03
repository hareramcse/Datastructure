package com.hs.medium;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class ReorderList {
	public ListNode reorderList(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode mid = LinkedListUtil.findMiddle(head);
		ListNode nextOfMid = mid.next;
		mid.next = null;

		ListNode head1 = head;
		ListNode head2 = LinkedListUtil.reverseByRecursion(nextOfMid);
		merge(head1, head2);
		return head;
	}

	private void merge(ListNode l1, ListNode l2) {
		while (l1 != null && l2 != null) {
			ListNode next = l1.next;
			l1.next = l2;
			l1 = l2;
			l2 = next;
		}
	}

	public static void main(String[] args) {
		ReorderList list = new ReorderList();

		ListNode head = new ListNode(5);
		head.next = new ListNode(10);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(20);
		head.next.next.next.next = new ListNode(25);
		head.next.next.next.next.next = new ListNode(30);
		head.next.next.next.next.next.next = new ListNode(35);
		head.next.next.next.next.next.next.next = new ListNode(40);
		head.next.next.next.next.next.next.next.next = new ListNode(45);

		ListNode reverseList = list.reorderList(head);
		LinkedListUtil.printLinkedList(reverseList);
	}
}