package com.hs.linkedlist;

import com.hs.basic.Node;

// 160. Intersection of Two Linked Lists Leetcode
class IntersectionOfTwoLinkedList {
	public Node findMergePoint(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;
		while (temp1 != temp2) {
			temp1 = temp1 == null ? head2 : temp1.next;
			temp2 = temp2 == null ? head1 : temp2.next;
		}
		return temp1;
	}

	public static void main(String[] args) {
		IntersectionOfTwoLinkedList list = new IntersectionOfTwoLinkedList();

		// creating first linked list
		Node head1 = new Node(4);
		head1.next = new Node(1);
		head1.next.next = new Node(8);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);

		// creating second linked list
		Node head2 = new Node(5);
		head2.next = new Node(6);
		head2.next.next = new Node(1);
		head2.next.next.next = new Node(8);
		head2.next.next.next.next = new Node(4);
		head2.next.next.next.next.next = new Node(5);
		Node findMergePoint = list.findMergePoint(head1, head2);
		System.out.println("The node of intersection is " + findMergePoint.data);
	}
}