package com.hs.hard;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode current = head;
		int count = 0;
		while (current != null && count != k) {
			current = current.next;
			count++;
		}
		if (count == k) {
			current = reverseKGroup(current, k);
			while (count-- > 0) {
				ListNode temp = head.next;
				head.next = current;
				current = head;
				head = temp;
			}
			head = current;
		}
		return head;
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