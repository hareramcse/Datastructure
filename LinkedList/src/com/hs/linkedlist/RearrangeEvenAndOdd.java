package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 328. Odd Even Linked List Leetcode
public class RearrangeEvenAndOdd {

	// Function to rearrange the odd and even nodes
	public Node rearrange(Node head) {
		if (head == null)
			return null;

		Node odd = head;
		Node even = head.next;
		Node evenHead = even;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public static void main(String args[]) {
		RearrangeEvenAndOdd list = new RearrangeEvenAndOdd();
		Node head = LinkedListUtil.addLast(null, 8);
		head = LinkedListUtil.addLast(head, 7);
		head = LinkedListUtil.addLast(head, 6);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 5);
		head = LinkedListUtil.addLast(head, 1);
		head = LinkedListUtil.addLast(head, 2);
		head = LinkedListUtil.addLast(head, 10);

		System.out.println("Linked List:");
		LinkedListUtil.printLinkedList(head);
		System.out.println("Rearranged List");
		head = list.rearrange(head);
		LinkedListUtil.printLinkedList(head);
	}
}