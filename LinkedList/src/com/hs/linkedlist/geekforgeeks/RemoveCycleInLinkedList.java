package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

public class RemoveCycleInLinkedList {

	private void detectAndRemoveLoop(Node head) {
		Node slow = head;
		Node fast = head.next;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		/* If loop exists */
		if (slow == fast) {
			slow = head;
			while (slow != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}

			/* since fast->next is the looping point */
			fast.next = null; /* remove loop */

		}
	}

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		RemoveCycleInLinkedList list = new RemoveCycleInLinkedList();
		Node head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);

		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next.next;
		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}
}
