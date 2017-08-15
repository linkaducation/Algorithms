package org.Algorithm.InterviewAlgorithm.netease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/15.
 * 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，
 * 其中有一些位置（不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，
 * 顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
 *
 * 思路：筛选出所有的模糊数字，全排列，插入到原数组，判断顺序对是否正确
 */
public class SortQueue {
    private static ArrayList<int[]> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = in.nextInt();
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (arr[i] != 0) {
                    list.add(arr[i]);
                }
            }
            Collections.sort(list);
            ArrayList<Integer> unVistied = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!list.contains(i)) {
                    unVistied.add(i);
                }
            }
            getAllSort(unVistied, 0, unVistied.size());
            int count = 0;
            for (int i = 0; i < res.size(); i++) {
                int[] queue = res.get(i);
                int[] temp = new int[arr.length];
                for (int j = 1; j <= n; j++) {
                    temp[j] = arr[j];
                }
                for (int j = 1, l = 0; j <= n; j++) {
                    if (temp[j] == 0) {
                        temp[j] = queue[l++];
                    }
                }
                if (isTrue(temp, k)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    //获取全排列，每一个全排列放进数组
    private static void getAllSort(ArrayList<Integer> list, int st, int len) {
        if (st == len - 1) {
            int[] arr = new int[len];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            res.add(arr);
            return;
        }
        for (int i = st; i < len; i++) {
            swap(list, st, i);
            getAllSort(list, st + 1, len);
            swap(list, st, i);
        }
    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        Integer integer = list.get(i);
        list.set(i, list.get(j));
        list.set(j, integer);

    }

    //判断是否符合题目要求
    private static boolean isTrue(int[] arr, int k) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j] && i < j) {
                    count++;
                }
            }
        }
        return count == k;
    }
}
