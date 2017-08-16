package org.Algorithm.InterviewAlgorithm.netease;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/16.
 */
public class NumQueue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            ArrayList<ArrayDeque<Integer>> list = new ArrayList<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                list.add(getSort(arr[i]));
            }
            for (int i = 0; i < n; i++) {
                ArrayDeque<Integer> so = list.get(i);
                System.out.print(so.poll());
                for (int j = 1; j < arr[i]; j++) {
                    System.out.print(" " + so.poll());
                }
                System.out.println();
            }
        }
    }

    private static ArrayDeque<Integer> getSort(int n) {
        ArrayDeque<Integer> res = new ArrayDeque<>();
        for (int i = n;i >= 1 ; i--) {
            res.addFirst(i);
            res.addFirst(res.removeLast());
        }
        return res;
    }
}
