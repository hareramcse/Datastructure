package com.hs.leetcode.medium;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

public class RightRotateByKTimes {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;

		ListNode current = head;

		int length = 1;
		while (current.next != null) {
			length++;
			current = current.next;
		}

		current.next = head;
		k = k % length;
		k = length - k;
		while (k > 0) {
			k--;
			current = current.next;
		}

		head = current.next;
		current.next = null;
		return head;
	}

	public static void main(String[] args) {
		RightRotateByKTimes list = new RightRotateByKTimes();
		ListNode head = new ListNode(10);
		head.next = new ListNode(4);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(20);
		head.next.next.next.next = new ListNode(40);
		head.next.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next.next = new ListNode(25);
		head.next.next.next.next.next.next.next = new ListNode(30);
		head.next.next.next.next.next.next.next.next = new ListNode(60);

		ListNode rotatedHead = list.rotateRight(head, 2);
		LinkedListUtil.printLinkedList(rotatedHead);
	}
}