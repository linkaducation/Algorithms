package org.Algorithm.SwordForOffer;


import org.Algorithm.SwordForOffer.HelperClass.RandomListNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ellen on 2017/5/17.
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstAppearingOnce {
    ArrayList<Character> list = new ArrayList<>();
    HashMap<Character,Integer> map = new HashMap<>();

    public RandomListNode Clone(RandomListNode pHead) {

        RandomListNode  r= null;

        RandomListNode dummyNode = pHead;
        while (dummyNode != null) {
            r = new RandomListNode(dummyNode.label);
            String s = "abc";
            char[] chars = s.toCharArray();
            new String(chars);
            r.next = dummyNode.next;
            dummyNode.next = r;
            dummyNode = r.next;
        }
        //复制随机节点
        dummyNode = pHead;
        while (dummyNode.next != null) {
            if (dummyNode.random != null) {}
            dummyNode.next.random = dummyNode.random.next;
        }
        dummyNode = dummyNode.next.next;

    dummyNode = pHead.next;
    RandomListNode temp = new RandomListNode(0);
    temp.next = dummyNode;
        while (dummyNode != null && dummyNode.next != null) {
        dummyNode.next = dummyNode.next.next;
        dummyNode = dummyNode.next;
    }
        return temp.next;
}

    public void Insert(char ch) {
        if (map.containsKey(ch)){
            map.put(ch,map.get(ch) + 1);
        } else {
            map.put(ch,1);
            list.add(ch);
        }
    }

    public char FirstAppearingOnce() {
        char k = '#';
        for (Character character : list) {
            if (map.get(character) == 1) {
                k = character;
                break;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        FirstAppearingOnce fao = new FirstAppearingOnce();
        char[] array = new char[]{'g', 'o', 'o', 'g', 'l', 'e'};
        for (int i = 0; i < array.length; i++) {
            fao.Insert(array[0]);
            char c = fao.FirstAppearingOnce();
            System.out.print(c + " \t");
        }
//        int[] array = new int[128];
//        System.out.println(Arrays.toString(array));
    }
}
