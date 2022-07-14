package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 61. Rotate List Leetcode
public class RightRotateByKTimes {

	public Node rightRotateKTimes(Node head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;

		Node current = head;

		int length = 1;
		while (current.next != null) {
			length++;
			current = current.next;
		}

		current.next = head;
		k = k % length;
		k = length - k;
		while (k > 0) {
			k--;
			current = current.next;
		}

		head = current.next;
		current.next = null;
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