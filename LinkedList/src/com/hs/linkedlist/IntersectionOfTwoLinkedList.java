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

	private Node findMergePoint(Node head1, Node head2) {
		int firstLength = length(head1);
        int secondLength = length(head2);
        int diff = secondLength - firstLength;
        if (firstLength > secondLength) {
            Node tmp = head1;
            head1 = head2;
            head2 = tmp;
            diff = firstLength - secondLength;
        }
        for (int i = 0; i < diff; i++) {
            head2 = head2.next;
        }
        while (head1.data != head2.data) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
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