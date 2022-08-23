package com.hs.other;

import com.hs.basic.ListNode;

public class FlatteningALinkedList {
	public ListNode flatten(ListNode root) {
		if (root == null || root.next == null)
			return root;

		root.next = flatten(root.next);
		root = mergeTwoLists(root, root.next);
		return root;
	}

	private ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode temp = new ListNode(0);
		ListNode res = temp;

		while (a != null && b != null) {
			if (a.val < b.val) {
				temp.bottom = a;
				temp = temp.bottom;
				a = a.bottom;
			} else {
				temp.bottom = b;
				temp = temp.bottom;
				b = b.bottom;
			}
		}

		if (a != null)
			temp.bottom = a;
		else
			temp.bottom = b;
		return res.bottom;
	}
}