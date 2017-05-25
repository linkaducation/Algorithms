package org.Algorithm.SwordForOffer;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

import java.util.ArrayList;


/**
 * Created by Ellen on 2017/5/5.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class ReverseLinkedList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        Stack<Integer> stack = new Stack<>();
//        while (listNode != null) {
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        while(!stack.isEmpty()){
//            list.add(stack.pop());
//        }
//        return list;

        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
