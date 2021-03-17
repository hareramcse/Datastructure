package com.hs.linkedlist.madeeasy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class RightRotateByKTimes {

	private Node rightRotateKTimes(Node head, int k) {
		Node temp = head;
		while (k-- > 0 && temp != null) {
			temp = temp.next;
		}
		Node kthNode = temp;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;
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
