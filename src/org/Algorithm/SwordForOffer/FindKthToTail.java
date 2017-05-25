package org.Algorithm.SwordForOffer;

import org.Algorithm.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/5/8.
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode pre = head;
        ListNode p = head;
        for (int i = 1; i < k; i++) {
            if (pre.next == null) {
                return null;
            }
            pre = pre.next;
        }
        while (pre.next != null) {
            pre = pre.next;
            p = p.next;
        }
        return p;
    }
}
