package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;
import sun.reflect.generics.scope.DummyScope;

/**
 * Created by Ellen on 2017/6/13. 给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数
 * 
 * 给出链表1->2->3->4->5->null和k=2 返回4->5->1->2->3->null
 */
public class RotateRight {
	public ListNode rotateRight(ListNode head, int k) {
		// write your code here
        if (head == null) {
            return null;
        }
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
            if (node == null) {
                node = head;
            }
        }
        ListNode fast = node;
        ListNode slowTem = new ListNode(0);
        ListNode slow = head;
        slowTem.next = slow;
        while (fast != null) {
            slowTem = slowTem.next;
            fast = fast.next;
            slow = slow.next;
        }
        slowTem.next = null;

        ListNode dummy = new ListNode(0);
        ListNode tem = dummy;
        dummy.next = slow;
        while (slow != null) {
            slow = slow.next;
            tem = tem.next;
        }
        tem.next = head;
        return dummy.next;
    }

}
