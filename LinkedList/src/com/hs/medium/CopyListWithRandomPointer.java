package com.hs.medium;

import java.util.HashMap;
import java.util.Map;

import com.hs.easy.ListNode;

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

		temp = head;
		while (temp != null) {
			ListNode node = map.get(temp);
			node.next = (temp.next != null) ? map.get(temp.next) : null;
			node.random = (temp.random != null) ? map.get(temp.random) : null;
			temp = temp.next;
		}
		return map.get(head);
	}
}
