package com.hs.leetcode.hard;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		int length = length(head);

		ListNode dummy = new ListNode();
		dummy.next = head;

		ListNode previous = dummy;
		ListNode current;
		ListNode nextNode;

		while (length >= k) {
			current = previous.next;
			nextNode = current.next;
			for (int i = 1; i < k; i++) {
				current.next = nextNode.next;
				nextNode.next = previous.next;
				previous.next = nextNode;
				nextNode = current.next;
			}
			previous = current;
			length -= k;
		}
		return dummy.next;
	}

	private int length(ListNode head) {
		int length = 0;
		while (head != null) {
			++length;
			head = head.next;
		}
		return length;
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup list = new ReverseNodesInKGroup();
		ListNode head = new ListNode(10);
		head.next = new ListNode(4);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(20);
		head.next.next.next.next = new ListNode(25);
		head.next.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next.next = new ListNode(35);
		head.next.next.next.next.next.next.next = new ListNode(30);

		ListNode rev = list.reverseKGroup(head, 3);
		LinkedListUtil.printLinkedList(rev);
	}
}