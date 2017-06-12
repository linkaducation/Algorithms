package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/12.
 * 用插入排序对链表排序
 * Given 1->3->2->0->null, return 0->1->2->3->null
 */
public class InsertionSortList {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            while (temp != null) {
                if (temp.val < node.val) {
                    int tem = node.val;
                    node.val = temp.val;
                    temp.val = tem;
                }
                temp = temp.next;
            }
            node = node.next;
        }
        return head;
    }
}
