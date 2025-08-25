package com.hs.easy;

public class RemoveCycleInLinkedList {
	public void detectAndRemoveLoop(ListNode head) {
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

		if (!loopExist)
			return;

		slow = head;
		ListNode temp = null;
		while (slow != fast) {
			temp = fast;
			slow = slow.next;
			fast = fast.next;
		}

		// here slow and fast pointer will point to start node of the loop
		// so we need just previous node of the starting loop
		temp.next = null; // remove loop
	}

	public static void main(String[] args) {
		RemoveCycleInLinkedList list = new RemoveCycleInLinkedList();
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
		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		LinkedListUtil.printLinkedList(head);
	}
}