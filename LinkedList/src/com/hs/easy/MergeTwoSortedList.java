package com.hs.easy;

public class MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;

		if (list2 == null)
			return list1;

		if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}

	public static void main(String[] args) {
		MergeTwoSortedList list = new MergeTwoSortedList();

		ListNode head1 = LinkedListUtil.addLast(null, 10);
		head1 = LinkedListUtil.addLast(head1, 20);
		head1 = LinkedListUtil.addLast(head1, 30);
		head1 = LinkedListUtil.addLast(head1, 40);

		ListNode head2 = LinkedListUtil.addLast(null, 35);
		head2 = LinkedListUtil.addLast(head2, 45);
		head2 = LinkedListUtil.addLast(head2, 50);
		head2 = LinkedListUtil.addLast(head2, 60);
		head2 = LinkedListUtil.addLast(head2, 70);
		head2 = LinkedListUtil.addLast(head2, 80);
		head2 = LinkedListUtil.addLast(head2, 90);

		ListNode mergeTwoList = list.mergeTwoLists(head1, head2);
		LinkedListUtil.printLinkedList(mergeTwoList);
	}
}