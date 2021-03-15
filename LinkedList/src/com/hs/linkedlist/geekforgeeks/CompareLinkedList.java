package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

public class CompareLinkedList {
	private static boolean compareLists(Node head1, Node head2) {
		while (head1 != null && head2 != null) {
			if (head1.data != head2.data)
				return false;

			head1 = head1.next;
			head2 = head2.next;
		}
		return (head1 == null && head2 == null);
	}

	public static void main(String[] args) {
		Node head1 = new Node(10);
		head1.next = new Node(20);
		head1.next.next = new Node(30);
		head1.next.next = new Node(40);

		Node head2 = new Node(10);
		head2.next = new Node(20);
		head2.next.next = new Node(30);
		head2.next.next = new Node(40);

		System.out.println(compareLists(head1, head2));
	}

}
