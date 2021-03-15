package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class FindMiddleNodeOfLinkedList {

	private Node findMiddle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(70);
		head.next.next.next.next.next.next.next = new Node(80);

		FindMiddleNodeOfLinkedList it = new FindMiddleNodeOfLinkedList();
		Node middleNode = it.findMiddle(head);
		System.out.println(middleNode.data);
	}
}
