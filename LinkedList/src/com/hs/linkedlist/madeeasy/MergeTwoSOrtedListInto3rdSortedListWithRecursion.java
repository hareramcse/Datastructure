package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class MergeTwoSOrtedListInto3rdSortedListWithRecursion {
	Node head = null;

	private void addBefore(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	private Node mergeTwoList(Node head1, Node head2) {
		Node result = new Node();
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		if (head1.data > head2.data) {
			result = head2;
			result.next = mergeTwoList(head1, head2.next);
		} else {
			result = head1;
			result.next = mergeTwoList(head1.next, head2);
		}
		return result;
	}

	private void printList(Node head) {
		Node temp = head;
		if (head == null) {
			System.out.println("List is empty");
		}
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("NULL");
	}

	public static void main(String[] args) {
		MergeTwoSOrtedListInto3rdSortedListWithRecursion list1 = new MergeTwoSOrtedListInto3rdSortedListWithRecursion();
		list1.addBefore(40);
		list1.addBefore(30);
		list1.addBefore(20);
		list1.addBefore(10);

		MergeTwoSOrtedListInto3rdSortedListWithRecursion list2 = new MergeTwoSOrtedListInto3rdSortedListWithRecursion();
		list2.addBefore(90);
		list2.addBefore(80);
		list2.addBefore(70);
		list2.addBefore(60);
		list2.addBefore(50);
		list2.addBefore(35);

		MergeTwoSOrtedListInto3rdSortedListWithRecursion result = new MergeTwoSOrtedListInto3rdSortedListWithRecursion();

		Node mergeTwoList = result.mergeTwoList(list1.head, list2.head);
		result.printList(mergeTwoList);
	}
}
