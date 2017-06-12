package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/12. 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点
 * 给出链表1->2->3->4->5->null和 n = 2. 删除倒数第二个节点之后，这个链表将变成1->2->3->5->null.
 */
public class RemoveNthFromEnd {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @param n:
	 *            An integer.
	 * @return: The head of linked list.
	 */
	ListNode removeNthFromEnd(ListNode head, int n) {
		// write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
