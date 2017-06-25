package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/25.
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTail {
	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode tempNode = head;
		int i = 0;
		while (tempNode != null && i < k) {
			tempNode = tempNode.next;
			i++;
		}
		if (i != k - 1) {
			return null;
		}
		while (tempNode != null) {
			tempNode = tempNode.next;
			head = head.next;
		}
		return head;
	}
}
