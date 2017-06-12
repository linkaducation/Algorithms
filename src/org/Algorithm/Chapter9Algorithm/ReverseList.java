package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/12.
 * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 */
public class ReverseList {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode last = null;
        ListNode node;
        while (head != null) {
            node = head.next;
            head.next = last;
            last = head;
            head = node;
        }
        return last;
    }
}
