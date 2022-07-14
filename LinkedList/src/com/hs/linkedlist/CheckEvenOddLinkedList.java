package com.hs.linkedlist;

import com.hs.basic.Node;

public class CheckEvenOddLinkedList {

	private boolean checkEvenOdd(Node head) {
		boolean even = false;
		while (head != null && head.next != null) {
			head = head.next.next;
		}
		if (head == null) {
			even = true;
		}
		return even;
	}

	public static void main(String[] args) {
		Node head = new Node(40);
		head.next = new Node(30);
		head.next.next = new Node(70);
		head.next.next.next = new Node(60);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(90);

		CheckEvenOddLinkedList list = new CheckEvenOddLinkedList();
		boolean isEven = list.checkEvenOdd(head);
		System.out.println(isEven);
	}
}
