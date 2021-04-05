package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class ReArrangeLinkedListInZigZagFashion {

	// This function distributes the Node in zigzag fashion
	private void zigZagList(Node head) {
		// If flag is true, then next node should be greater in the desired output.
		boolean flag = true;

		// Traverse linked list starting from head.
		Node current = head;
		while (current != null && current.next != null) {
			if (flag == true) /* "<" relation expected */
			{
				/*
				 * If we have a situation like A > B > C where A, B and C are consecutive Nodes
				 * in list we get A > B < C by swapping B and C
				 */
				if (current.data > current.next.data) {
					int temp = current.data;
					current.data = current.next.data;
					current.next.data = temp;
				}
			} else /* ">" relation expected */
			{
				/*
				 * If we have a situation like A < B < C where A, B and C are consecutive Nodes
				 * in list we get A < C > B by swapping B and C
				 */
				if (current.data < current.next.data) {
					int temp = current.data;
					current.data = current.next.data;
					current.next.data = temp;
				}
			}

			current = current.next;

			/* flip flag for reverse checking */
			flag = !flag;
		}
	}

	public static void main(String[] args) {
		ReArrangeLinkedListInZigZagFashion list = new ReArrangeLinkedListInZigZagFashion();

		// create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1
		// answer should be -> 3 7 4 8 2 6 1

		Node head = LinkedListUtil.addLast(null, 1);
		head = LinkedListUtil.addLast(head, 2);
		head = LinkedListUtil.addLast(head, 6);
		head = LinkedListUtil.addLast(head, 8);
		head = LinkedListUtil.addLast(head, 7);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 4);

		System.out.println("Given linked list ");
		LinkedListUtil.printLinkedList(head);

		list.zigZagList(head);

		System.out.println("Zig Zag Linked list ");
		LinkedListUtil.printLinkedList(head);
	}
}