package com.hs.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.hs.basic.Node;

// 160. Intersection of Two Linked Lists Leetcode
class IntersectionOfTwoLinkedList {

	public Node findMergePoint(Node head1, Node head2) {
		Set<Node> nodes = new HashSet<>();

		// traverse the first list and insert the address of each node into the set
		while (head1 != null) {
			nodes.add(head1);
			head1 = head1.next;
		}

		// now traverse the second list and find the first node that is
		// already present in the set
		while (head2 != null) {
			// return the current node if it is found in the set
			if (nodes.contains(head2)) {
				return head2;
			}
			head2 = head2.next;
		}

		// we reach here if lists do not intersect
		return null;
	}

	public static void main(String[] args) {
		IntersectionOfTwoLinkedList list = new IntersectionOfTwoLinkedList();

		// creating first linked list
		Node head1 = new Node(3);
		head1.next = new Node(6);
		head1.next.next = new Node(15);
		head1.next.next.next = new Node(15);
		head1.next.next.next.next = new Node(30);

		// creating second linked list
		Node head2 = new Node(10);
		head2.next = new Node(15);
		head2.next.next = new Node(30);

		System.out.println("The node of intersection is " + list.findMergePoint(head1, head2).data);

	}
}