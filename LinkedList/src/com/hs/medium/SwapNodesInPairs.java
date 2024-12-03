package com.hs.medium;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// Store head of list after two nodes
		ListNode remaing = head.next.next;

		// Change head
		ListNode newHead = head.next;

		// Change next of second node
		head.next.next = head;

		// Recur for remaining list and change next of head
		head.next = swapPairs(remaing);

		// Return new head of modified list
		return newHead;
	}

	public static void main(String[] args) {
		SwapNodesInPairs list = new SwapNodesInPairs();
		ListNode head = new ListNode(10);
		head.next = new ListNode(4);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(20);
		head.next.next.next.next = new ListNode(40);
		head.next.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next.next = new ListNode(25);
		head.next.next.next.next.next.next.next = new ListNode(30);
		head.next.next.next.next.next.next.next.next = new ListNode(60);

		ListNode reverseList = list.swapPairs(head);
		LinkedListUtil.printLinkedList(reverseList);
	}
}