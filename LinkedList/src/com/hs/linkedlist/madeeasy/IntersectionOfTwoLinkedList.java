package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class IntersectionOfTwoLinkedList {

	private int length(Node head) {
		int len = 0;
		Node temp = head;
		while (temp != null) {
			len++;
			temp = temp.next;
		}

		return len;
	}

	private Node findIntersectionNode(Node list1, Node list2) {
		int d1 = length(list1);
		int d2 = length(list2);

		int diff = d1 - d2;

		if (diff > 0) {
			while (diff != 0) {
				list1 = list1.next;
				diff--;
			}
		} else {
			while (diff != 0) {
				list2 = list2.next;
				diff++;
			}
		}

		while (list1 != null && list2 != null) {
			if (list1.data == list2.data) {
				break;
			}
			list1 = list1.next;
			list2 = list2.next;
		}
		return list1;
	}

	public static void main(String[] args) {
		Node head1 = new Node(10);
		head1.next = new Node(20);
		head1.next.next = new Node(30);
		head1.next.next.next = new Node(40);

		Node head = new Node(90);
		head.next = new Node(50);
		head.next.next = new Node(60);
		head.next.next.next = new Node(70);
		head.next.next.next.next = new Node(30);
		head.next.next.next.next.next = new Node(40);

		IntersectionOfTwoLinkedList it = new IntersectionOfTwoLinkedList();
		Node intersectionNode = it.findIntersectionNode(head1, head);
		System.out.println(intersectionNode.data);
	}
}
