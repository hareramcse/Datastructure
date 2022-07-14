package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class MultiplyTwoLinkedListNumbers {

	// Multiply contents of two linked lists
	private long multiplyTwoLists(Node first, Node second) {
		int num1 = 0, num2 = 0;

		// Generate numbers from linked lists
		while (first != null || second != null) {
			if (first != null) {
				num1 = num1 * 10 + first.data;
				first = first.next;
			}
			if (second != null) {
				num2 = num2 * 10 + second.data;
				second = second.next;
			}
		}

		// Return multiplication of two numbers
		return num1 * num2;
	}

	public static void main(String args[]) {
		MultiplyTwoLinkedListNumbers list = new MultiplyTwoLinkedListNumbers();

		Node first = LinkedListUtil.addLast(null, 9);
		first = LinkedListUtil.addLast(first, 4);
		first = LinkedListUtil.addLast(first, 6);

		System.out.printf("First List is: ");
		LinkedListUtil.printLinkedList(first);

		Node second = LinkedListUtil.addLast(null, 4);
		second = LinkedListUtil.addLast(second, 8);

		System.out.printf("Second List is: ");
		LinkedListUtil.printLinkedList(second);

		// Multiply the two lists and see result
		System.out.printf("Result is: ");
		System.out.println(list.multiplyTwoLists(first, second));
	}
}