package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/12.
 * 给一个链表，两两交换其中的节点，然后返回交换后的链表
 * 给出 1->2->3->4, 你应该返回的链表是 2->1->4->3
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        // head->n1->n2->...
        // => head->n2->n1->...
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next, n2 = head.next.next;
            n1.next = n2.next;
            n2.next = n1;
            head.next = n2;
            head = n1;
        }
        return dummy.next;
    }
}
