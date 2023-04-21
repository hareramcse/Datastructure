package com.hs.seelater;

import java.util.HashMap;
import java.util.Map;

import com.hs.basic.ListNode;

public class CopyListWithRandomPointer {
	public ListNode copyRandomList(ListNode head) {
		Map<ListNode, ListNode> map = new HashMap<>();
		ListNode temp = head;

		// first iteration for inserting deep nodes of every node in the map.
		while (temp != null) {
			ListNode newNode = new ListNode(temp.val);
			map.put(temp, newNode);
			temp = temp.next;
		}
		ListNode t = head;

		// second iteration for linking next and random pointer as given question.
		while (t != null) {
			ListNode node = map.get(t);
			node.next = (t.next != null) ? map.get(t.next) : null;
			node.random = (t.random != null) ? map.get(t.random) : null;
			t = t.next;
		}
		return map.get(head);
	}
}
