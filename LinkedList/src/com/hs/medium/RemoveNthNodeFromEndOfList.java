package com.hs.medium;

import com.hs.easy.ListNode;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode();
		dummy.next = head;

		ListNode slow = dummy;
		ListNode fast = dummy;

		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList list = new RemoveNthNodeFromEndOfList();
		ListNode head = new ListNode(20);
		head.next = new ListNode(10);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);

		ListNode ListNode = list.removeNthFromEnd(head, 3);
		while (ListNode != null) {
			System.out.println(ListNode.val);
			ListNode = ListNode.next;
		}
	}
}