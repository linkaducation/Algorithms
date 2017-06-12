package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/12.
 * 找到单链表倒数第n个节点，保证链表中节点的最少数量为n
 */
public class NthToLast {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        while (node != null) {
            head = head.next;
            node = node.next;
        }
        return head;
    }
}
