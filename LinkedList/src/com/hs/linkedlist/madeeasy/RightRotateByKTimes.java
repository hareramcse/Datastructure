package com.hs.linkedlist.madeeasy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class RightRotateByKTimes {

	private Node rightRotateKTimes(Node head, int k) {
		Node head1 = head;
		while (k-- > 0 && head1 != null) {
			head1 = head1.next;
		}
		Node kthNode = head1;
		while (head1.next != null) {
			head1 = head1.next;
		}
		head1.next = head;
		head = kthNode.next;
		kthNode.next = null;
		return head;
	}

	public static void main(String[] args) {
		RightRotateByKTimes list = new RightRotateByKTimes();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(40);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(25);
		head.next.next.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next.next.next = new Node(60);

		Node rotatedHead = list.rightRotateKTimes(head, 2);
		LinkedListUtil.printLinkedList(rotatedHead);
	}
}
