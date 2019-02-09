package com.hs.linkedlist;

class IntersectionOfTwoLinkedList {

	private int length(Node list) {
		int lenght = 0;
		Node tmp = list;
		while (tmp != null) {
			lenght++;
			tmp = tmp.next;
		}
		return lenght;
	}

	private Node findMergePoint(Node firstList, Node secondList) {
		int firstLength = length(firstList);
		int secondLength = length(secondList);
		int diff = secondLength - firstLength;
		if (firstLength > secondLength) {
			Node tmp = firstList;
			firstList = secondList;
			secondList = tmp;
			diff = firstLength - secondLength;
		}
		for (int i = 0; i < diff; i++) {
			secondList = secondList.next;
		}
		while (firstList != null && secondList != null) {
			if (firstList.data == secondList.data) {
				return firstList;
			}
			firstList = firstList.next;
			secondList = secondList.next;
		}
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