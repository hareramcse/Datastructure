package com.hs.medium;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class AddOneToLinkedList {
	private ListNode addOne(ListNode head) {

		// Add 1 to linked list from end to beginning
		int carry = addWithCarry(head);

		// If there is carry after processing all ListNodes,
		// then we need to add a new ListNode to linked list
		if (carry > 0) {
			ListNode newNode = new ListNode(carry);
			newNode.next = head;
			return newNode; // New ListNode becomes head now
		}
		return head;
	}

	// carry after all ListNodes are processed.
	public int addWithCarry(ListNode head) {

		// If linked list is empty, then return carry
		if (head == null)
			return 1;

		// Add carry returned be next ListNode call
		int res = head.val + addWithCarry(head.next);

		// Update data
		head.val = res % 10;
		// return new carry
		return res / 10;
	}

	public static void main(String[] args) {
		AddOneToLinkedList list = new AddOneToLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(9);
		head.next.next = new ListNode(9);
		head.next.next.next = new ListNode(9);

		System.out.print("List is ");
		LinkedListUtil.printLinkedList(head);

		head = list.addOne(head);
		System.out.println();
		System.out.print("Resultant list is ");
		LinkedListUtil.printLinkedList(head);
	}
}