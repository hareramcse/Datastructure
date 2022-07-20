package com.hs.linkedlist;

import com.hs.basic.Node;

// 141. Linked List Cycle Leetcode
public class CheckLoopInLinkedList {
	public boolean detectLoop(Node head) {
		if (head == null)
			return false;

		Node slow = head;
		Node fast = head;

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
		CheckLoopInLinkedList list = new CheckLoopInLinkedList();

		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(70);
		head.next.next.next.next.next.next.next = new Node(80);

		// Creating a loop for testing
		head.next.next.next.next.next.next.next = head.next.next;

		boolean b = list.detectLoop(head);
		System.out.println("Loop found " + b);
	}
}