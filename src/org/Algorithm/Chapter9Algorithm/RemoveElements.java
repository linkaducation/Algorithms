package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/12.
 * 删除链表中等于给定值val的所有节点。
 * 给出链表 1->2->3->3->4->5->3, 和 val = 3, 你需要返回删除3之后的链表：1->2->4->5。
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode node = dummyNode;
        while (head != null) {
            if (head.val == val) {
                node.next = head.next;
                head = head.next;
            } else {
                node = head;
                head = head.next;
            }
        }
        return dummyNode.next;
    }
}
