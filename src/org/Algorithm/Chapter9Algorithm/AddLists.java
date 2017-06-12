package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/12. 你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
 * 给出两个链表 3->1->5->null 和 5->9->2->null，返回 8->0->8->null
 */
public class AddLists {
	public ListNode addLists(ListNode l1, ListNode l2) {
		// write your code here
        ListNode head = new ListNode(0);
        ListNode tempNode = head;
        boolean flag = false;
        while (l1 != null || l2 != null) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
            }
            if (l2 != null) {
                temp += l2.val;
            }
            if (flag) {
                temp += 1;
                flag = false;
            }
            if (temp >= 10) {
                flag = true;
            }
            ListNode node = new ListNode(temp % 10);
            tempNode.next = node;
            tempNode = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 !=null) {
                l2 = l2.next;
            }
        }
        if (flag) {
            ListNode last = new ListNode(1);
            last.next = null;
            tempNode.next = last;
        }
        return head.next;
	}
}
