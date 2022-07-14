package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

class CheckLinkedListIsPolyndrom {
	Node head;

	private boolean checkIfPolindrom(Node head) {
		Node mid = LinkedListUtil.findMiddle(head);
		Node reverse = LinkedListUtil.reverseByRecursion(mid);
		while (head != mid && reverse != null) {
			if (head.data != reverse.data) {
				return false;
			}
			head = head.next;
			reverse = reverse.next;
		}
		return true;
	}

	private void push(char new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String[] args) {
		/* Start with the empty list */
		CheckLinkedListIsPolyndrom list = new CheckLinkedListIsPolyndrom();

		char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
		for (int i = 0; i < 7; i++) {
			list.push(str[i]);
			LinkedListUtil.printLinkedList(list.head);
			boolean b = list.checkIfPolindrom(list.head);
			if (b) {
				System.out.println("Is Palindrome");
				System.out.println("");
			} else {
				System.out.println("Not Palindrome");
				System.out.println("");
			}
		}
	}
}