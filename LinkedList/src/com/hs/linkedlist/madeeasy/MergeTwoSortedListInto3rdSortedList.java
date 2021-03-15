package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class MergeTwoSortedListInto3rdSortedList {
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

	private MergeTwoSortedListInto3rdSortedList mergeTwoList(Node head1, Node head2,
			MergeTwoSortedListInto3rdSortedList result) {
		Node list1 = head1;
		Node list2 = head2;

		while (list1 != null && list2 != null) {
			if (list1.data > list2.data) {
				result.addBefore(list2.data);
				list2 = list2.next;
			}

			if (list1.data < list2.data) {
				result.addBefore(list1.data);
				list1 = list1.next;
			}
		}

		while (list1 != null) {
			result.addBefore(list1.data);
			list1 = list1.next;
		}

		while (list2 != null) {
			result.addBefore(list2.data);
			list2 = list2.next;
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
		MergeTwoSortedListInto3rdSortedList list1 = new MergeTwoSortedListInto3rdSortedList();
		list1.addBefore(40);
		list1.addBefore(30);
		list1.addBefore(20);
		list1.addBefore(10);

		MergeTwoSortedListInto3rdSortedList list2 = new MergeTwoSortedListInto3rdSortedList();
		list2.addBefore(90);
		list2.addBefore(80);
		list2.addBefore(70);
		list2.addBefore(60);
		list2.addBefore(50);
		list2.addBefore(35);

		MergeTwoSortedListInto3rdSortedList result = new MergeTwoSortedListInto3rdSortedList();

		MergeTwoSortedListInto3rdSortedList mergeTwoList = result.mergeTwoList(list1.head, list2.head, result);
		result.printList(mergeTwoList.head);
	}
}
