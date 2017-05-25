package org.Algorithm.SwordForOffer;

import org.Algorithm.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/5/8.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newlist = null;
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = newlist;
            newlist = head;
            head = temp;
        }
        return newlist;
    }
}
