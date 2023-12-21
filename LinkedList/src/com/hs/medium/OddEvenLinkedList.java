package com.hs.medium;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class OddEvenLinkedList {
	public ListNode rearrange(ListNode head) {
		if (head == null)
			return null;

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public static void main(String args[]) {
		OddEvenLinkedList list = new OddEvenLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);

		System.out.println("Linked list before arrange:");
		LinkedListUtil.printLinkedList(head);
		System.out.println("Rearranged List:");
		head = list.rearrange(head);
		LinkedListUtil.printLinkedList(head);
	}
}