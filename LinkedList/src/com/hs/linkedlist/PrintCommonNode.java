package com.hs.linkedlist;

import java.util.Vector;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class PrintCommonNode {

	private void printCommonNodes(Node head1, Node head2) {
		Vector<Integer> map = new Vector<Integer>();

		while (head1 != null) {
			map.add(head1.data);
			head1 = head1.next;
		}

		while (head2 != null) {
			if (map.contains(head2.data)) {
				System.out.print(head2.data + " ");
			}
			head2 = head2.next;
		}
	}

	public static void main(String[] args) {
		PrintCommonNode list = new PrintCommonNode();

		Node head1 = LinkedListUtil.addLast(null, 10);
		head1 = LinkedListUtil.addLast(head1, 4);
		head1 = LinkedListUtil.addLast(head1, 15);
		head1 = LinkedListUtil.addLast(head1, 20);

		Node head2 = LinkedListUtil.addLast(null, 40);
		head2 = LinkedListUtil.addLast(head2, 4);
		head2 = LinkedListUtil.addLast(head2, 15);
		head2 = LinkedListUtil.addLast(head2, 10);
		head2 = LinkedListUtil.addLast(head2, 20);

		list.printCommonNodes(head1, head2);
	}
}
