package com.hs.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.hs.basic.Node;

public class CountPairsInTwoListWhoseSumIsGivenValue {
	// count all pairs from both the lists whose sum is equal to a given value
	public int countPairs(Node head1, Node head2, int x) {
		int count = 0;

		Set<Integer> set = new HashSet<Integer>();
		while (head1 != null) {
			set.add(head1.data);
			head1 = head1.next;
		}

		while (head2 != null) {
			// find (x - head2->data) in 'set'
			if (set.contains(x - head2.data)) {
				count++;
			}
			head2 = head2.next;
		}
		return count;
	}

	public static void main(String[] args) {
		CountPairsInTwoListWhoseSumIsGivenValue list = new CountPairsInTwoListWhoseSumIsGivenValue();

		Node head1 = new Node(3);
		head1.next = new Node(1);
		head1.next.next = new Node(5);
		head1.next.next.next = new Node(7);

		Node head2 = new Node(8);
		head2.next = new Node(2);
		head2.next.next = new Node(5);
		head2.next.next.next = new Node(3);

		int x = 10;

		System.out.println("Count = " + list.countPairs(head1, head2, x));
	}
}