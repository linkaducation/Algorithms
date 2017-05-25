package org.Algorithm.SwordForOffer;

import java.util.ArrayList;

/**
 * Created by Ellen on 2017/5/15.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0) {
            return list;
        }
        int len = array.length, i = 0, j = len - 1;
        int count = array[i] + array[j];
        boolean flag = true;
        while (flag) {
            if (i == j) {
                flag = false;
                return list;
            }
            if (count < sum) {
                i++;
                count = array[i] + array[j];
            }
            if (count > sum) {
                j--;
                count = array[i] + array[j];
            }
            if (count == sum) {
                list.add(array[i]);
                list.add(array[j]);
                flag = false;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindNumbersWithSum fw = new FindNumbersWithSum();
        ArrayList<Integer> list = fw.FindNumbersWithSum(new int[]{1,2,4,7,11,16}, 17);
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
    }
}
