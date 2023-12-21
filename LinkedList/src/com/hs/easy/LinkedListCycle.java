package com.hs.easy;

public class LinkedListCycle {
	public boolean detectLoop(ListNode head) {
		if (head == null)
			return false;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedListCycle list = new LinkedListCycle();

		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);
		head.next.next.next.next.next.next = new ListNode(70);
		head.next.next.next.next.next.next.next = new ListNode(80);

		// Creating a loop for testing
		head.next.next.next.next.next.next.next = head.next.next;

		boolean result = list.detectLoop(head);
		System.out.println(result);
	}
}