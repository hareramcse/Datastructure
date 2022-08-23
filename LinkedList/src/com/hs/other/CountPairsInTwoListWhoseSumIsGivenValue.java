package com.hs.other;

import java.util.HashSet;
import java.util.Set;

import com.hs.basic.ListNode;

public class CountPairsInTwoListWhoseSumIsGivenValue {
	// count all pairs from both the lists whose sum is equal to a given value
	public int countPairs(ListNode head1, ListNode head2, int x) {
		int count = 0;

		Set<Integer> set = new HashSet<Integer>();
		while (head1 != null) {
			set.add(head1.val);
			head1 = head1.next;
		}

		while (head2 != null) {
			// find (x - head2->data) in 'set'
			if (set.contains(x - head2.val)) {
				count++;
			}
			head2 = head2.next;
		}
		return count;
	}

	public static void main(String[] args) {
		CountPairsInTwoListWhoseSumIsGivenValue list = new CountPairsInTwoListWhoseSumIsGivenValue();

		ListNode head1 = new ListNode(3);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(5);
		head1.next.next.next = new ListNode(7);

		ListNode head2 = new ListNode(8);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(5);
		head2.next.next.next = new ListNode(3);

		int x = 10;

		System.out.println("Count = " + list.countPairs(head1, head2, x));
	}
}