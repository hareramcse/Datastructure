package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

class FindMidElement {
	Node head;

	private void printMiddle(Node head) {
		Node slow = head;
		Node fast = head;
		if (head != null) {
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			System.out.println("The middle element is [" + slow.data + "] \n");
		}
	}

	private void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String[] args) {
		FindMidElement list = new FindMidElement();
		for (int i = 5; i > 0; --i) {
			list.push(i);
			LinkedListUtil.printLinkedList(list.head);
			list.printMiddle(list.head);
		}
	}
}