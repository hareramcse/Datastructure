package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

public class GetNodeDataFromTail {

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
		GetNodeDataFromTail list = new GetNodeDataFromTail();
		Node head = new Node(20);
		head.next = new Node(10);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);

		Node node = list.findNthNode(head, 3);
		System.out.println(node.data);
	}
}
