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
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);

		System.out.println("Linked list before arrange:");
		LinkedListUtil.printLinkedList(head);
		System.out.println("Rearranged List:");
		head = list.rearrange(head);
		LinkedListUtil.printLinkedList(head);
	}
}