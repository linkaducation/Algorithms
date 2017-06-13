package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

/**
 * Created by Ellen on 2017/6/13.
 * 设计一种方式检查一个链表是否为回文链表
 * 1->2->1 就是一个回文链表
 * s思路：找到中点，将后面的链表反向，再对比两个链表
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        ListNode medle = getMed(head);
        ListNode headB = reverseList(medle);
        while (head != null && headB != null) {
            if (head.val != headB.val) {
                return false;
            }
            head = head.next;
            headB = headB.next;
        }
        return true;
    }

    private ListNode getMed(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode dummy = null;
        ListNode head = node;
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummy;
            dummy = head;
            head = temp;
        }
        return dummy;
    }
}
