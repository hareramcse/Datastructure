package com.hs.hard;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode current = head;
		int count = 0;
		while (current != null && count < k) {
			current = current.next;
			count++;
		}

		if (count == k) {
			current = head;
			ListNode prev = null;
			for (int i = 0; i < k; i++) {
				ListNode next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}

			head.next = reverseKGroup(current, k);
			return prev;
		}
		return head;
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup list = new ReverseNodesInKGroup();
		ListNode head = new ListNode(5);
		head.next = new ListNode(10);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(20);
		head.next.next.next.next = new ListNode(25);
		head.next.next.next.next.next = new ListNode(30);
		head.next.next.next.next.next.next = new ListNode(35);
		head.next.next.next.next.next.next.next = new ListNode(40);

		ListNode rev = list.reverseKGroup(head, 3);
		LinkedListUtil.printLinkedList(rev);
	}
}