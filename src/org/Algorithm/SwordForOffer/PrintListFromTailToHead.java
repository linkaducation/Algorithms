package org.Algorithm.SwordForOffer;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;

import java.util.ArrayList;

/**
 * Created by Ellen on 2017/8/23.
 */
public class PrintListFromTailToHead {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }


}
