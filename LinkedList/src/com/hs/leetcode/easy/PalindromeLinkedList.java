package com.hs.leetcode.easy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

//TC O(N), SC O(1)
public class PalindromeLinkedList {
	public boolean checkIfPolindrom(ListNode head) {
		ListNode mid = LinkedListUtil.findMiddle(head);
		ListNode reverse = LinkedListUtil.reverseByRecursion(mid);
		while (reverse != null) {
			if (head.val != reverse.val) {
				return false;
			}
			head = head.next;
			reverse = reverse.next;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeLinkedList list = new PalindromeLinkedList();
		ListNode head = new ListNode(10);
		head.next = new ListNode(4);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(10);

		boolean result = list.checkIfPolindrom(head);
		System.out.println(result);
	}
}