package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

class InsertAtMid {

	private void insertAtMid(Node head, int data) {
		// if list is empty
		if (head == null) {
			head = new Node(data);
		} else {
			// get a new node
			Node newNode = new Node(data);

			// assign values to the slow and fast pointers
			Node slow = head;
			Node fast = head.next;

			while (fast != null && fast.next != null) {
				// move slow pointer to next node
				slow = slow.next;
				fast = fast.next.next;
			}

			// insert the 'newNode' and adjust the required links
			newNode.next = slow.next;
			slow.next = newNode;
		}
	}

	public static void main(String[] args) {
		InsertAtMid list = new InsertAtMid();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);

		System.out.println("Linked list before" + " insertion: ");
		LinkedListUtil.printLinkedList(head);

		int data = 3;
		list.insertAtMid(head, data);

		System.out.println("\nLinked list after" + " insertion: ");
		LinkedListUtil.printLinkedList(head);
	}
}