package com.hs.medium;

import com.hs.easy.ListNode;

public class FindStartNodeOfLoop {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean loopExist = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExist = true;
				break;
			}
		}

		if (loopExist) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return null;
	}

	public static void main(String[] args) {
		FindStartNodeOfLoop list = new FindStartNodeOfLoop();
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);
		head.next.next.next.next.next.next = new ListNode(70);
		head.next.next.next.next.next.next.next = new ListNode(80);

		head.next.next.next.next.next.next.next = head.next.next;

		ListNode startListNode = list.detectCycle(head);
		System.out.println(startListNode.val);
	}
}