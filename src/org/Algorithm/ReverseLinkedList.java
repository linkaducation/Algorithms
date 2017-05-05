package org.Algorithm;

import org.Algorithm.HelperClass.ListNode;

import java.util.ArrayList;
/**
 * Created by Ellen on 2017/5/5.
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
        if (listNode != null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
