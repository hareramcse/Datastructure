package com.hs.easy;

class IntersectionOfTwoLinkedList {
	public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
		ListNode temp2 = head2;
		while (temp1 != temp2) {
			temp1 = temp1 == null ? head2 : temp1.next;
			temp2 = temp2 == null ? head1 : temp2.next;
		}
		return temp1;
    }

	public static void main(String[] args) {
		IntersectionOfTwoLinkedList list = new IntersectionOfTwoLinkedList();

		// creating first linked list
		ListNode head1 = new ListNode(4);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(8);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);

		// creating second linked list
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(1);
		head2.next.next.next = head1.next.next;
		ListNode result = list.getIntersectionNode(head1, head2);
		System.out.println("The ListNode of intersection is " + result.val);
	}
}