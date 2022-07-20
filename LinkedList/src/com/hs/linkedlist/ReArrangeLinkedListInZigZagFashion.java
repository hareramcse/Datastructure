package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class ReArrangeLinkedListInZigZagFashion {

	// This function distributes the Node in zigzag fashion
	public void zigZagList(Node head) {
		// If flag is true, then next node should be greater in the desired output.
		boolean flag = true;

		// Traverse linked list starting from head.
		Node current = head;
		while (current != null && current.next != null) {
			if (flag == true) {
				// If we have a situation like A > B > C where A, B and C are consecutive Nodes
				// then we get A > B < C by swapping B and C
				if (current.data > current.next.data) {
					int temp = current.data;
					current.data = current.next.data;
					current.next.data = temp;
				}
			} else {
				// If we have a situation like A < B < C where A, B and C are consecutive Nodes
				// in list we get A < C > B by swapping B and C
				if (current.data < current.next.data) {
					int temp = current.data;
					current.data = current.next.data;
					current.next.data = temp;
				}
			}

			current = current.next;

			// flip flag for reverse checking
			flag = !flag;
		}
	}

	public static void main(String[] args) {
		ReArrangeLinkedListInZigZagFashion list = new ReArrangeLinkedListInZigZagFashion();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(6);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(7);
		head.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next.next = new Node(4);

		System.out.println("Given linked list ");
		LinkedListUtil.printLinkedList(head);

		list.zigZagList(head);

		System.out.println("Zig Zag Linked list ");
		LinkedListUtil.printLinkedList(head);
	}
}