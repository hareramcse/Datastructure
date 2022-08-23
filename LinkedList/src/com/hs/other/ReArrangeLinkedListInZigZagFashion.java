package com.hs.other;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

public class ReArrangeLinkedListInZigZagFashion {
	public void zigZagList(ListNode head) {
		// If flag is true, then next ListNode should be greater in the desired output.
		boolean flag = true;

		ListNode current = head;
		while (current != null && current.next != null) {
			if (flag == true) {
				// If we have a situation like A > B > C where A, B and C are consecutive ListNodes
				// then we get A > B < C by swapping B and C
				if (current.val > current.next.val) {
					int temp = current.val;
					current.val = current.next.val;
					current.next.val = temp;
				}
			} else {
				// If we have a situation like A < B < C where A, B and C are consecutive ListNodes
				// in list we get A < C > B by swapping B and C
				if (current.val < current.next.val) {
					int temp = current.val;
					current.val = current.next.val;
					current.next.val = temp;
				}
			}

			current = current.next;

			// flip flag for reverse checking
			flag = !flag;
		}
	}

	public static void main(String[] args) {
		ReArrangeLinkedListInZigZagFashion list = new ReArrangeLinkedListInZigZagFashion();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(4);

		System.out.println("Given linked list ");
		LinkedListUtil.printLinkedList(head);

		list.zigZagList(head);

		System.out.println("Zig Zag Linked list ");
		LinkedListUtil.printLinkedList(head);
	}
}