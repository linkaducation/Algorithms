package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/12. 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。 你应该保留两部分内链表节点原有的相对顺序。
 * 
 * 给定链表 1->4->3->2->5->2->null，并且 x=3
 * 返回 1->2->2->4->3->5->null
 */
public class Partition {
	public ListNode partition(ListNode head, int x) {
		// write your code here
        ListNode preNode = new ListNode(0);
        ListNode pNode = preNode;
        ListNode postNode = new ListNode(0);
        ListNode poNode = postNode;
        while (head != null) {
            if (head.val < x) {
                pNode.next = head;
                pNode = pNode.next;
            } else {
                poNode.next = head;
                poNode = poNode.next;
            }
            head = head.next;
        }
        poNode.next = null;
        pNode.next = postNode.next;
        return preNode.next;
	}
}
