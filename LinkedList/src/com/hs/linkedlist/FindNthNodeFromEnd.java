package com.hs.linkedlist;

import com.hs.basic.Node;

public class FindNthNodeFromEnd {

	private Node findNthNode(Node head, int n) {
		Node temp1 = head;
		Node temp2 = head;
		int count = 0;
		while (temp1 != null && count != n) {
			count++;
			temp1 = temp1.next;
		}

		while (temp2 != null && temp1 != null) {
			temp2 = temp2.next;
			temp1 = temp1.next;
		}

		return temp2;
	}

	public static void main(String[] args) {
		FindNthNodeFromEnd list = new FindNthNodeFromEnd();

		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(70);
		head.next.next.next.next.next.next.next = new Node(80);

		Node nthNode = list.findNthNode(head, 2);
		System.out.println(nthNode.data);
	}
}
