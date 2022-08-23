package com.hs.leetcode.medium;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

public class ReorderLinkedList {

	// find the mid element
	// reverse the second half of the element
	// add alternatively from the 1st list and 2nd list into dummy ListNode
	public ListNode reorderList(ListNode head) {
		ListNode mid = LinkedListUtil.findMiddle(head);
		ListNode nextOfMid = mid.next;
		mid.next = null;

		ListNode head1 = head;
		ListNode head2 = LinkedListUtil.reverseByRecursion(nextOfMid);

		// iterate till last ListNode of the list
		while (head2 != null) {
			ListNode temp1 = head1.next;
			ListNode temp2 = head2.next;
			head1.next = head2;
			head2.next = temp1;
			head1 = temp1;
			head2 = temp2;
		}

		// Assign the head of the new list to head pointer
		return head;
	}

	public static void main(String[] args) {
		ReorderLinkedList list = new ReorderLinkedList();

		ListNode head = new ListNode(10);
		head.next = new ListNode(4);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(20);
		head.next.next.next.next = new ListNode(45);
		head.next.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next.next = new ListNode(25);
		head.next.next.next.next.next.next.next = new ListNode(30);
		head.next.next.next.next.next.next.next.next = new ListNode(60);

		ListNode reverseList = list.reorderList(head);
		LinkedListUtil.printLinkedList(reverseList);
	}
}