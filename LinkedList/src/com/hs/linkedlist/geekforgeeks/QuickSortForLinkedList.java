package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class QuickSortForLinkedList {

	// takes first and last node, but do not break any links in the whole linked
	// list
	private Node partitionLast(Node start, Node end) {
		if (start == end || start == null || end == null)
			return start;

		Node pivot_prev = start;
		Node curr = start;
		int pivot = end.data;

		// iterate till one before the end, no need to iterate till the end because end
		// is pivot
		while (start != end) {
			if (start.data < pivot) {
				// keep tracks of last modified item
				pivot_prev = curr;
				int temp = curr.data;
				curr.data = start.data;
				start.data = temp;
				curr = curr.next;
			}
			start = start.next;
		}

		// swap the position of curr i.e. next suitable index and pivot
		int temp = curr.data;
		curr.data = pivot;
		end.data = temp;

		// return one previous to current because current is now pointing to pivot
		return pivot_prev;
	}

	private void sort(Node start, Node end) {
		if (start == end)
			return;

		// split list and partition recurse
		Node pivot_prev = partitionLast(start, end);
		sort(start, pivot_prev);

		// if pivot is picked and moved to the start, that means start and pivot is same
		// so pick from next of pivot
		if (pivot_prev != null && pivot_prev == start)
			sort(pivot_prev.next, end);

		// if pivot is in between of the list, start from next of pivot,
		// since we have pivot_prev, so we move two nodes
		else if (pivot_prev != null && pivot_prev.next != null)
			sort(pivot_prev.next.next, end);
	}

	public static void main(String[] args) {
		QuickSortForLinkedList list = new QuickSortForLinkedList();

		Node head = LinkedListUtil.addLast(null, 30);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 4);
		head = LinkedListUtil.addLast(head, 20);
		head = LinkedListUtil.addLast(head, 5);
		head = LinkedListUtil.addLast(head, 50);

		Node endNode = head;
		while (endNode.next != null) {
			endNode = endNode.next;
		}

		System.out.println("Linked List before sorting");
		LinkedListUtil.printLinkedList(head);

		list.sort(head, endNode);

		System.out.println("\nLinked List after sorting");
		LinkedListUtil.printLinkedList(head);
	}
}