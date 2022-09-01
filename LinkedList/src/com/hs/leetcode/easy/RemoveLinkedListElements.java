package com.hs.leetcode.easy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		// if number is starting of the list
		while (head != null && head.val == val) {
			head = head.next;
		}

		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.next.val == val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
	
	public static void main(String args[]) {
		RemoveLinkedListElements list = new RemoveLinkedListElements();

		ListNode head = new ListNode(20);
		head.next = new ListNode(13);
		head.next.next = new ListNode(13);
		head.next.next.next = new ListNode(11);
		head.next.next.next.next = new ListNode(11);
		head.next.next.next.next.next = new ListNode(11);

		System.out.println("List before removal of duplicates");
		LinkedListUtil.printLinkedList(head);

		list.removeElements(head, 13);

		System.out.println("List after removal of elements");
		LinkedListUtil.printLinkedList(head);
	}
}