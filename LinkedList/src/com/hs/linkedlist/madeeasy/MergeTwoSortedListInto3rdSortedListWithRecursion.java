package com.hs.linkedlist.madeeasy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class MergeTwoSortedListInto3rdSortedListWithRecursion {

	private Node mergeTwoList(Node head1, Node head2, Node result) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		if (head1.data > head2.data) {
			result = head2;
			result.next = mergeTwoList(head1, head2.next, result);
		} else {
			result = head1;
			result.next = mergeTwoList(head1.next, head2, result);
		}
		return result;
	}

	public static void main(String[] args) {
		MergeTwoSortedListInto3rdSortedListWithRecursion list = new MergeTwoSortedListInto3rdSortedListWithRecursion();
		
		Node head1 = LinkedListUtil.addLast(null, 10);
		head1 = LinkedListUtil.addLast(head1, 20);
		head1 = LinkedListUtil.addLast(head1, 30);
		head1 = LinkedListUtil.addLast(head1, 40);

		Node head2 = LinkedListUtil.addLast(null, 35);
		head2 = LinkedListUtil.addLast(head2, 45);
		head2 = LinkedListUtil.addLast(head2, 50);
		head2 = LinkedListUtil.addLast(head2, 60);
		head2 = LinkedListUtil.addLast(head2, 70);
		head2 = LinkedListUtil.addLast(head2, 80);
		head2 = LinkedListUtil.addLast(head2, 90);

		Node result = new Node();

		Node mergeTwoList = list.mergeTwoList(head1, head2, result);
		LinkedListUtil.printLinkedList(mergeTwoList);
	}
}
