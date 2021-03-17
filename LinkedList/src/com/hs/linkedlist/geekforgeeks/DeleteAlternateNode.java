package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class DeleteAlternateNode {

	private void deleteAlt(Node head) {
		if (head == null)
			return;

		Node current = head;
		Node nextNode = head.next;

		while (current != null && nextNode != null) {
			/* Change next link of current node */
			current.next = nextNode.next;

			/* Free node */
			nextNode = null;

			/* Update current and nextNode */
			current = current.next;
			if (current != null) {
				nextNode = current.next;
			}
		}
	}

	public static void main(String args[]) {
		DeleteAlternateNode list = new DeleteAlternateNode();

		Node head = LinkedListUtil.addLast(null, 5);
		head = LinkedListUtil.addLast(head, 4);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 2);
		head = LinkedListUtil.addLast(head, 1);

		System.out.println("Linked List before calling deleteAlt() ");
		LinkedListUtil.printLinkedList(head);

		list.deleteAlt(head);

		System.out.println("Linked List after calling deleteAlt() ");
		LinkedListUtil.printLinkedList(head);
	}

}