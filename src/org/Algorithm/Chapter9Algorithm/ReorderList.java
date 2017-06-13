package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/13.
 * 给定一个单链表L: L0→L1→…→Ln-1→Ln,
 * 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 必须在不改变节点值的情况下进行原地操作
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		// write your code here
        if (head == null || head.next == null) {
            return;
        }
        ListNode meddle = getMeddle(head);
        ListNode list = reverseList(meddle.next);

        meddle.next = null;
        merge(head, list);
    }

	private ListNode getMeddle(ListNode node) {
        ListNode fast = node.next;
	    ListNode slow = node;
	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = null;
	    while (head != null) {
	        ListNode temp = head.next;
	        head.next = dummy;
	        dummy = head;
	        head = temp;
        }
        return dummy;
    }

    private void merge(ListNode head, ListNode tail) {
	    int index = 0;
	    ListNode dummy = new ListNode(0);
	    while (head != null && tail != null) {
	        if (index % 2 == 0) {
	            dummy.next = head;
	            head = head.next;
            } else {
	            dummy.next = tail;
	            tail = tail.next;
            }
	        index++;
	        dummy = dummy.next;
        }
        if (head != null) {
	        dummy.next = head;
        } else {
	        dummy.next = tail;
        }
    }
}
