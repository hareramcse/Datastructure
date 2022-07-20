package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class RemoveCycleInLinkedList {

	public void detectAndRemoveLoop(Node head) {
		Node slow = head;
		Node fast = head;

		boolean loopExist = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExist = true;
				break;
			}
		}

		// If loop exists
		if (loopExist) {
			slow = head;
			Node temp = null;
			while (slow != fast) {
				temp = fast;
				slow = slow.next;
				fast = fast.next;
			}

			// here slow and fast pointer will point to start node of the loop
			// so we need just previous node of the starting loop node
			temp.next = null; // remove loop
		}
	}

	public static void main(String[] args) {
		RemoveCycleInLinkedList list = new RemoveCycleInLinkedList();
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
		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		LinkedListUtil.printLinkedList(head);
	}
}