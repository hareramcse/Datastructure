package com.hs.leetcode.hard;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;

		// this case is only for if length of linkedlist size is not divisible by k
		boolean isCheck = check(head, k);
		if (isCheck) {
			return head;
		}

		int count = 0;
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null) {
			head.next = reverseKGroup(next, k);
		}

		return prev;
	}

	private boolean check(ListNode head, int k) {
		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count < k ? true : false;
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