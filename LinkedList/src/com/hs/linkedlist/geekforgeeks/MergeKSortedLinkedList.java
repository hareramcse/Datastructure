package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class MergeKSortedLinkedList {
	/*
	 * Takes two lists sorted in increasing order, and merge their nodes together to
	 * make one big sorted list. Below function takes O(Log n) extra space for
	 * recursive calls, but it can be easily modified to work with same time and
	 * O(1) extra space
	 */
	private Node sortedMerge(Node head1, Node head2) {
		Node result = null;
		/* Base cases */
		if (head1 == null)
			return head2;
		else if (head2 == null)
			return head1;

		/* Pick either a or b, and recur */
		if (head1.data <= head2.data) {
			result = head1;
			result.next = sortedMerge(head1.next, head2);
		} else {
			result = head2;
			result.next = sortedMerge(head1, head2.next);
		}

		return result;
	}

	// The main function that takes an array of lists
	// arr[0..last] and generates the sorted output
	public Node mergeKLists(Node arr[], int noOfList) {
		// repeat until only one list is left
		while (noOfList != 0) {
			int i = 0, j = noOfList;

			// (i, j) forms a pair
			while (i < j) {
				// merge List i with List j and store merged list in List i
				arr[i] = sortedMerge(arr[i], arr[j]);

				// consider next pair
				i++;
				j--;

				// If all pairs are merged, update last
				if (i >= j)
					noOfList = j;
			}
		}

		return arr[0];
	}

	public static void main(String args[]) {
		MergeKSortedLinkedList list = new MergeKSortedLinkedList();
		int k = 3; // Number of linked lists

		// an array of pointers storing the head nodes of the linked lists
		Node arr[] = new Node[k];

		arr[0] = new Node(1);
		arr[0].next = new Node(3);
		arr[0].next.next = new Node(5);
		arr[0].next.next.next = new Node(7);

		arr[1] = new Node(2);
		arr[1].next = new Node(4);
		arr[1].next.next = new Node(6);
		arr[1].next.next.next = new Node(8);

		arr[2] = new Node(0);
		arr[2].next = new Node(9);
		arr[2].next.next = new Node(10);
		arr[2].next.next.next = new Node(11);

		// Merge all lists
		Node head = list.mergeKLists(arr, k - 1);
		LinkedListUtil.printLinkedList(head);
	}
}