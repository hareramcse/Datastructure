package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class PrintCommonNode {
	Node head = null;

	public void addLast(int data) {
		Node temp = head;
		if (temp == null) {
			head = new Node(data);
			return;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
	}

	private void printCommon(Node head1, Node head2) {
		while (head1 != null && head2.next != null) {
			if (head1.data == head2.next.data) {
				System.out.println(head1.data);
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1.data > head2.data) {
				head2 = head2.next;
			} else {
				head1 = head1.next;
			}
		}

	}
	
	public static void main(String[] args) {
		PrintCommonNode list1 = new PrintCommonNode();
		list1.addLast(10);
		list1.addLast(4);
		list1.addLast(15);
		list1.addLast(20);

		PrintCommonNode list2 = new PrintCommonNode();
		list2.addLast(40);
		list2.addLast(4);
		list2.addLast(15);
		list2.addLast(10);
		list2.addLast(20);

		list1.printCommon(list1.head, list2.head);
	}
}
