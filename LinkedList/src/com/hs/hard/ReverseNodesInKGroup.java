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
			// reverse first k nodes
			ListNode newHead = reverseKNodes(head, k);

			// 'head' is now the tail of this reversed segment
			head.next = reverseKGroup(current, k);
			return newHead;
		}
		return head;
	}

	private ListNode reverseKNodes(ListNode head, int k) {
		ListNode newHead = null;
		while (k > 0 && head != null) {
			ListNode nextNode = head.next;
			head.next = newHead;
			newHead = head;
			head = nextNode;
			k--;
		}

		// return new head after reversing k nodes
		return newHead;
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