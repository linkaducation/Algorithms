package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ellen on 2017/6/13. 在 O(n log n) 时间复杂度和常数级的空间复杂度下给链表排序
 */
public class SortList {
	// 借助java堆排序
	public ListNode sortList(ListNode head) {
		// write your code here
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		while (head != null) {
			queue.offer(head);
			head = head.next;
		}
		ListNode node = new ListNode(0);
		ListNode dummy = node;
		while (!queue.isEmpty()) {
			ListNode temp = queue.poll();
			if (temp == null) {
				continue;
			}
			dummy.next = temp;
			dummy = dummy.next;
		}
		dummy.next = null;
		return node.next;
	}

	public static void main(String[] args) {
		SortList sl = new SortList();
		ListNode node = new ListNode(111);
		ListNode node2 = new ListNode(2);
		node.next = node2;
		ListNode list = sl.sortList2(node);
		while (list != null) {
			System.out.println(list.val);
			list = list.next;
		}
	}

	// 归并排序
	public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);

        ListNode right = sortList2(middle.next);
        middle.next = null;
        ListNode left = sortList2(head);

		return merge(left, right);
    }

	private ListNode findMiddle (ListNode node) {
	    ListNode fast = node.next;
	    ListNode slow = node;
	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
	    ListNode dummy = new ListNode(0);
	    ListNode tail = dummy;
	    while (left != null && right != null) {
	        if (left.val < right.val) {
	            tail.next = left;
	            left = left.next;
            } else {
	            tail.next = right;
	            right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
	        tail.next = left;
        } else {
	        tail.next = right;
        }
        return dummy.next;
    }

}
