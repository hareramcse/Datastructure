package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class CheckIfLinkedListPolindrom {

	private boolean checkIfPolindrom(Node head) {
		Node mid = LinkedListUtil.findMiddle(head);
		Node reverse = LinkedListUtil.reverseByRecursion(mid);
		while (head != mid && reverse != null) {
			if (head.data != reverse.data) {
				return false;
			}
			head = head.next;
			reverse = reverse.next;
		}
		return true;
	}

	public static void main(String[] args) {
		CheckIfLinkedListPolindrom list = new CheckIfLinkedListPolindrom();

		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);

		boolean b = list.checkIfPolindrom(head);
		System.out.println(b);
	}
}
