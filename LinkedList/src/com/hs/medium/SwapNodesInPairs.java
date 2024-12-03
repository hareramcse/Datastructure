package com.hs.medium;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// Identify the first and second nodes
		ListNode firstNode = head;
		ListNode secondNode = head.next;

		// Swap the first two nodes
		firstNode.next = swapPairs(secondNode.next);
		secondNode.next = firstNode;

		// Return the new head (second node)
		return secondNode;
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