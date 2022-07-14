package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

class RotateLinkedList {

	private Node rotate(Node head, int k) {
		if (k == 0)
			return null;

		// Let us understand the below code for example k = 4
		// and list = 10->20->30->40->50->60.
		Node current = head;

		// current will either point to kth or NULL after this
		// loop. current will point to node 40 in the above example
		int count = 1;
		while (count < k && current != null) {
			current = current.next;
			count++;
		}

		// If current is NULL, k is greater than or equal to count
		// of nodes in linked list. Don't change the list in this case
		if (current == null)
			return current;

		// current points to kth node. Store it in a variable.
		// kthNode points to node 40 in the above example
		Node kthNode = current;

		// current will point to last node after this loop
		// current will point to node 60 in the above example
		while (current.next != null) {
			current = current.next;
		}

		// Change next of last node to previous head
		// Next of 60 is now changed to node 10

		current.next = head;

		// Change head to (k+1)th node
		// head is now changed to node 50
		head = kthNode.next;

		// change next of kth node to null
		kthNode.next = null;
		
		return head;
	}

	public static void main(String args[]) {
		RotateLinkedList list = new RotateLinkedList();

		Node head = LinkedListUtil.addLast(null, 10);
		head = LinkedListUtil.addLast(head, 20);
		head = LinkedListUtil.addLast(head, 30);
		head = LinkedListUtil.addLast(head, 40);
		head = LinkedListUtil.addLast(head, 50);
		head = LinkedListUtil.addLast(head, 60);

		System.out.println("Given list");
		LinkedListUtil.printLinkedList(head);

		head = list.rotate(head, 4);

		System.out.println("Rotated Linked List");
		LinkedListUtil.printLinkedList(head);
	}
}
