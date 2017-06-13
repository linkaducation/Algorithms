package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;
import org.Algorithm.SwordForOffer.HelperClass.RandomListNode;

import java.util.Random;

/**
 * Created by Ellen on 2017/6/13. 给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点。 返回一个深拷贝的链表。
 */
public class CopyRandomList {
	public RandomListNode copyRandomList(RandomListNode head) {
		// write your code here
        RandomListNode node = head;
        //复制节点，加入到每一个原节点后
        while (node != null) {
            RandomListNode rn = new RandomListNode(node.label);
            RandomListNode temp = node.next;
            node.next = rn;
            rn.next = temp;
            node = node.next.next;
        }
        //复制随机指针
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        //分割链表
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        RandomListNode temp = dummy;
        while (head != null) {
            if (temp.next != null) {
                temp.next = head.next;
                temp = temp.next;
            }
            head = temp.next;
        }
        return dummy.next;
	}
}
