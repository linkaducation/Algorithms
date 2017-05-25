package org.Algorithm.SwordForOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellen on 2017/5/8.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并
 * 保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < array.length; i++){
            if ((array[i]&1) == 1){
                list.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++){
            if ((array[i]&1) == 0){
                list.add(array[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }
}
