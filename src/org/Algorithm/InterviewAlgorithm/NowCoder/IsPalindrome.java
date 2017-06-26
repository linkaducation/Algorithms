package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/26.
 * 请编写一个函数，检查链表是否为回文。
 */
public class IsPalindrome {
	public boolean isPalindrome(ListNode pHead) {
		ListNode low = pHead;
		ListNode fast = null;
		if (pHead.next != null) {
			fast = pHead.next;
		} else {
			return true;
		}
		while (fast.next != null && fast.next.next != null) {
			low = low.next;
			fast = fast.next.next;
		}
		ListNode reverse = null;
		if (fast.next != null) {
			reverse = low.next.next;
		} else {
			reverse = low.next;
		}
		//反转后半部分的链表
		ListNode dummy = null;
		while (reverse != null) {
			ListNode temp = reverse.next;
			reverse.next = dummy;
			dummy = reverse;
			reverse = temp;
		}
		while (dummy != null && pHead != null) {
			if (dummy.val != pHead.val) {
				return false;
			}
			dummy = dummy.next;
			pHead = pHead.next;
		}
		return true;
		//5,2,2,3,7,0,7,2,1,0,6,1,0,3,3,3,4,3,4,5,5,4,9,0,9,4,0,6,3,2,2,1,6,7,1,8,2,8,0,6,0,0,4,1,
		// 8,2,2,8,1,4,0,0,6,0,8,2,8,1,7,6,1,2,2,3,6,0,4,9,0,9,4,5,5,4,3,4,3,3,3,0,1,6,0,1,2,7,0,7,3,2,2,5
	}

	public static void main(String[] args) {
		IsPalindrome is = new IsPalindrome();
		Scanner in = new Scanner(System.in);

		ListNode headA = new ListNode(0);
		ListNode dummyA = headA;
		String s = in.next();

		String[] split = s.split(",");

		for (int i = 0; i < split.length; i++) {
			dummyA.next = new ListNode(Integer.valueOf(split[i]));
			dummyA = dummyA.next;
		}
		boolean palindrome = is.isPalindrome(headA.next);
		System.out.println(palindrome);
	}
}
