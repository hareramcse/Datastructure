package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class SwapLinkedListInPairs {

	private void swapNodes(Node head) {
		Node current = head;
		while (current != null && current.next != null) {
			int temp = current.data;
			current.data = current.next.data;
			current.next.data = temp;
			current = current.next.next;
		}
	}

	public static void main(String[] args) {
		SwapLinkedListInPairs list = new SwapLinkedListInPairs();

		Node head = LinkedListUtil.addLast(null, 7);
		head = LinkedListUtil.addLast(head, 6);
		head = LinkedListUtil.addLast(head, 5);
		head = LinkedListUtil.addLast(head, 4);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 2);
		head = LinkedListUtil.addLast(head, 1);

		System.out.print("Linked list before calling swapNodes()");
		System.out.println();
		LinkedListUtil.printLinkedList(head);

		list.swapNodes(head);
		System.out.println();
		LinkedListUtil.printLinkedList(head);
	}
}
