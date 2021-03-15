package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class CheckEvenOddLinkedList {

	private boolean checkEvenOdd(Node head) {
		Node temp = head;
		boolean even = false;
		while (temp != null && temp.next != null) {
			temp = temp.next.next;
		}
		if (temp == null) {
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
