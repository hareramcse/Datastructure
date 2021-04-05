package com.hs.linkedlist.geekforgeeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class CountPairsInTwoListWhoseSumIsGivenValue {
	// method to count all pairs from both the linked lists whose sum is equal to a
	// given value
	private int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
		int count = 0;

		Set<Integer> set = new HashSet<Integer>();

		// insert all the elements of 1st list in the hash table(unordered_set 'set')
		Iterator<Integer> itr = head1.iterator();
		while (itr.hasNext()) {
			set.add(itr.next());
		}

		itr = head2.iterator();
		// for each element of 2nd list
		while (itr.hasNext()) {
			// find (x - head2->data) in 'set'
			if (set.contains(x - itr.next())) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		CountPairsInTwoListWhoseSumIsGivenValue list = new CountPairsInTwoListWhoseSumIsGivenValue();
		Integer arr1[] = { 3, 1, 5, 7 };
		Integer arr2[] = { 8, 2, 5, 3 };

		// create linked list1 3->1->5->7
		LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));

		// create linked list2 8->2->5->3
		LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));

		int x = 10;

		System.out.println("Count = " + list.countPairs(head1, head2, x));
	}
}