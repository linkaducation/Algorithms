package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/26.
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 */
public class PlusAB {
	public ListNode plusAB(ListNode a, ListNode b) {
		// write code here
		ListNode head = a;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int k = 0;
		while (head != null && b != null) {
			int temp = head.val + b.val;
			head.val = (temp % 10 + k) % 10;
			head = head.next;
			dummy = dummy.next;
			b = b.next;
			k = temp / 10 + (temp % 10 + k) / 10;
		}
		//7 4 0 7 5 2 7 2 3 4
		if (k != 0 && b == null) {
			dummy.next = new ListNode(k);
			return a;
		} else {
			head = dummy;
		}
		while (b != null) {
			int temp = (b.val + k) % 10;
			b.val = temp;
			k = (b.val + k) / 10;
			head.next = b;
			head = head.next;
			b = b.next;
		}
		if (k != 0) {
			head.next = new ListNode(k);
		}
		return a;
	}

	public static void main(String[] args) {
		PlusAB plusAB = new PlusAB();
		Scanner in = new Scanner(System.in);
		ListNode headA = new ListNode(0);
		ListNode headB = new ListNode(0);
		ListNode dummyA = headA;
		ListNode dummyB = headB;
		for (int i = 0; i < 5; i++) {
			int temp = in.nextInt();
			dummyA.next = new ListNode(temp);
			dummyA = dummyA.next;
		}
		for (int i = 0; i < 5; i++) {
			dummyB.next = new ListNode(in.nextInt());
			dummyB = dummyB.next;
		}
		ListNode listNode = plusAB.plusAB(headA.next, headB.next);
		while (listNode != null) {
			System.out.print(listNode.val + "\t");
			listNode = listNode.next;
		}
	}
}
