package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Ellen on 2017/6/13.
 * 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度
 */
public class MergeKLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                queue.offer(lists.get(i));
            }
        }
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while (!queue.isEmpty()) {
            ListNode nhead = queue.poll();
            ListNode node = new ListNode(nhead.val);
            dummy.next = node;
            dummy = node;
            if (nhead.next != null) {
                queue.offer(nhead.next);
            }
        }
        return head.next;
    }
}
