package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class CheckIfLinkedListPolindrom {

	private boolean checkIfPolindrom(Node head) {
		Node temp = head;
		Node mid = findMiddle(temp);
		Node rev = reverseList(mid);
		while (temp != mid && rev != null) {
			if (temp.data != rev.data) {
				return false;
			}
			temp = temp.next;
			rev = rev.next;
		}
		return true;
	}

	private Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node reverseList = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reverseList;
	}

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
