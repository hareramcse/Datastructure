package com.hs.leetcode.easy;

import com.hs.basic.ListNode;

public class DecimalEquivalentOfBinaryLinkedList {
	public int decimalValue(ListNode head) {
		int res = 0;
		while (head != null) {
			// Multiply result by 2 and add head's data
			res = (res << 1) + head.val;
			head = head.next;
		}
		return res;
	}

	public static void main(String args[]) {
		DecimalEquivalentOfBinaryLinkedList list = new DecimalEquivalentOfBinaryLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);

		System.out.print("Decimal value is " + list.decimalValue(head));
	}
}