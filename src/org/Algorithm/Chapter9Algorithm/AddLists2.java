package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;


import java.util.Stack;

/**
 * Created by Ellen on 2017/6/12.
 * 假定用一个链表表示两个数，其中每个节点仅包含一个数字。假设这两个数的数字顺序排列，请设计一种方法将两个数相加，并将其结果表现为链表的形式
 *
 * 给出 6->1->7 + 2->9->5。即，617 + 295。
 返回 9->1->2。即，912 。
 */
public class AddLists2 {
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode left = l1, right = l2;
        Stack<Integer> lstack = getList(left);
        Stack<Integer> rstack = getList(right);
        int count = 0;
        ListNode node = null;
        while (!lstack.isEmpty() && !rstack.isEmpty()) {
            //2->8->2->8->2->9->6->4->5->2->5->2->null,
            //   5->8->9->5->6->5->1->8->7->5->5->null
            ListNode tempNode = new ListNode((lstack.peek() + rstack.peek() + count) % 10);
            count = (lstack.pop() + rstack.pop() + count) / 10;
            tempNode.next = node;
            node = tempNode;
        }
        while (!lstack.isEmpty()) {
            ListNode tempNode = new ListNode(lstack.pop() + count);
            tempNode.next = node;
            node = tempNode;
            count = 0;
        }
        while (!rstack.isEmpty()) {
            ListNode tempNode = new ListNode(rstack.pop() + count);
            tempNode.next = node;
            node = tempNode;
            count = 0;
        }
        if (count != 0) {
            ListNode tempNode = new ListNode(count);
            tempNode.next = node;
            node = tempNode;
        }
        return node;
    }

    private Stack<Integer> getList(ListNode node) {
        Stack<Integer> stack = new Stack();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }

}
