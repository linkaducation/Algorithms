package org.Algorithm.SwordForOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Ellen on 2017/6/7.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 */
public class MaxInWindows {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> list = new ArrayDeque<>();
        if (num == null || num.length <= 0 || size == 0) {
            return res;
        }
        int begin;
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (list.isEmpty()) {
                list.offer(i);
            } else if (begin > list.peekFirst()) {
                list.pollFirst();
            }
            while (!list.isEmpty() && num[i] >= num[list.peekLast()]) {
                list.pollLast();
            }
            list.add(i);
            if (begin >= 0) {
                res.add(num[list.peekFirst()]);
            }
        }
        return res;
    }
}
