package org.Algorithm.SwordForOffer;

import org.Algorithm.HelperClass.RandomListNode;

/**
 * Created by Ellen on 2017/5/10.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（
 * 注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone {
    RandomListNode newlist = null;

    public RandomListNode clone(RandomListNode pHead) {
        if (pHead != null) {
            RandomListNode pf = pHead;
            while (pf != null) {
                newlist = new RandomListNode(pf.label);
                newlist.next = pf.next;
                pf.next = newlist;
                pf = newlist.next;
            }

            pf = pHead;
            while (pf != null) {
                if (pf.random != null) {
                    pf.next.random = pf.random;
                }
                pf = pf.next.next;
            }

            RandomListNode head = pHead.next;
            RandomListNode cur = head;
            pf = pHead;
            //拆分链表
            while (pf != null) {
                pf.next = pf.next.next;
                if (cur.next != null)
                    cur.next = cur.next.next;
                cur = cur.next;
                pf = pf.next;
            }
            return head;
        }
        return null;
    }
}
