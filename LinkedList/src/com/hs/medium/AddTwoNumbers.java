package com.hs.medium;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); 
		ListNode temp = dummy; 
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1) {
            int sum = 0; 
            if(l1 != null) {
                sum += l1.val; 
                l1 = l1.next; 
            }
            
            if(l2 != null) {
                sum += l2.val; 
                l2 = l2.next; 
            }
            
            sum += carry; 
            carry = sum / 10; 
            ListNode newNode = new ListNode(sum % 10); 
            temp.next = newNode; 
            temp = temp.next; 
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		AddTwoNumbers obj = new AddTwoNumbers();
		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(3);

		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);

		ListNode result = obj.addTwoNumbers(head1, head2);
		LinkedListUtil.printLinkedList(result);
	}
}
