package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class ReverseLinkedListWithRecurson {

	private Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node reverseList = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reverseList;
	}

	private void printList(Node head) {
		Node temp = head;
		if (head == null) {
			System.out.println("List is empty");
		}
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("NULL");
	}

	public static void main(String[] args) {
		ReverseLinkedListWithRecurson list = new ReverseLinkedListWithRecurson();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(20);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(25);
		head.next.next.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next.next.next = new Node(60);

		Node reverseList = list.reverseList(head);
		list.printList(reverseList);
	}
}
