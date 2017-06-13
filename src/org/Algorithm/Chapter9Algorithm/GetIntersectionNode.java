package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/13.
 * 请写一个程序，找到两个单链表最开始的交叉节点
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        int aSize = getSize(headA);
        int bSize = getSize(headB);
        if (aSize > bSize) {
            for (int i = 0; i < aSize - bSize; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < bSize - aSize; i++) {
                headB = headB.next;
            }
        }
        return getNode(headA,headB);
    }

    private int getSize(ListNode node) {
        int count = 0;
        while (node != null) {
            count ++;
            node = node.next;
        }
        return count;
    }

    private ListNode getNode(ListNode aHead, ListNode bHead) {
        while (aHead != null && bHead != null) {
            if (aHead.val == bHead.val) {
                return aHead;
            } else {
                aHead = aHead.next;
                bHead = bHead.next;
            }
        }
        return null;
    }
}
