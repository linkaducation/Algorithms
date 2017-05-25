package org.Algorithm.SwordForOffer;

import org.Algorithm.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/5/14.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class CopyOnWriteArrayList {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return null;
        }
        int i = 0, j = 0;
        ListNode tempPhead1 = pHead1;
        ListNode tempPhead2 = pHead2;
        while (tempPhead1 != null) {
            i++;
            tempPhead1 = tempPhead1.next;
        }
        while (tempPhead2 != null) {
            j++;
            tempPhead2 = tempPhead2.next;
        }
        int temp;
        if (i > j) {
            temp = i - j;
            for (int k = 0; k < temp; k++) {
                pHead1 = pHead1.next;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        } else {
            temp = j - i;
            for (int k = 0; k < temp; k++) {
                pHead2 = pHead2.next;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead2;
        }
    }
}
