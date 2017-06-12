package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/12. 将两个排序链表合并为一个新的排序链表
 */
public class MergeTwoLists {
	/**
	 * @param l1
	 *            is the head of the linked list
	 * @param l2
	 *            is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// write your code here
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode node = new ListNode(0);
		ListNode tempNode = node;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tempNode.next = l1;
				l1 = l1.next;
			} else if (l1.val > l2.val) {
				tempNode.next = l2;
				l2 = l2.next;
			}
			tempNode = tempNode.next;
		}
		if (l1 != null) {
			tempNode.next = l1;
		}
		if (l2 != null) {
			tempNode.next = l2;
		}
		return node.next;
	}
}
