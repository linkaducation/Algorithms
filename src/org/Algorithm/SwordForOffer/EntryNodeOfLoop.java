package org.Algorithm.SwordForOffer;

import org.Algorithm.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/5/17.
 * 一个链表中包含环，请找出该链表的环的入口结点
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fastNode = pHead.next;
        ListNode slowNode = pHead;
        while (fastNode != slowNode) {
            if (fastNode.next != null) {
                if (fastNode.next.next != null) {
                    fastNode = fastNode.next.next;
                }
            }
            if (slowNode != null) {
                slowNode = slowNode.next;
            }
        }
        slowNode = slowNode.next;
        int count = 1;
        while (fastNode != slowNode) {
            slowNode = slowNode.next;
            count++;
        }
        fastNode = pHead;
        slowNode = pHead;
        for (int i = 0; i < count; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode != slowNode) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
