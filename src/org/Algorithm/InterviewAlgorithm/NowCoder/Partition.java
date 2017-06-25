package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/25.
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Partition {
	public ListNode partition(ListNode pHead, int x) {
		// write code here
		if (pHead == null) {
			return null;
		}
		ListNode min = new ListNode(0);
		ListNode minDummy = min;
		ListNode max = new ListNode(0);
		ListNode maxDummy = max;
		while (pHead != null) {
			if (pHead.val < x) {
				minDummy.next = pHead;
				pHead = pHead.next;
				minDummy = minDummy.next;
			} else {
				maxDummy.next = pHead;
				pHead = pHead.next;
				maxDummy = maxDummy.next;
			}
		}
		minDummy.next = max.next;
		maxDummy.next = null;
		return min.next;
	}
}
