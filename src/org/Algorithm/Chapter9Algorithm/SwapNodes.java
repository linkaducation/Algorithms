package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;



/**
 * Created by Ellen on 2017/6/13. 给你一个链表以及两个权值v1和v2，交换链表中权值为v1和v2的这两个节点。保证链表中节点权值各不相同，如果没有找到对应节点，那么什么也不用做 给出链表
 * 1->2->3->4->null ，以及 v1 = 2 ， v2 = 4 返回结果 1->4->3->2->null。
 */
public class SwapNodes {
	public ListNode swapNodes(ListNode head, int v1, int v2) {
		// Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node1Prev = null, node2Prev = null;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == v1) {
                node1Prev = cur;
            } else if (cur.next.val == v2) {
                node2Prev = cur;
            }
            cur = cur.next;
        }

        if (node1Prev == null || node2Prev == null) {
            return head;
        }

        if (node2Prev.next == node1Prev) {
            // make sure node2Prev.next is not node1Prev
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }

        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next;
        ListNode node2Next = node2.next;
        if (node1Prev.next == node2Prev) {
            node1Prev.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;

            node2Prev.next = node1;
            node1.next = node2Next;
        }
        return dummy.next;
    }
}
