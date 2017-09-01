package org.Algorithm.BestSolution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/9/1.
 * <p>
 * 窗口大小为3，滑动窗口，输出每个窗口的最大值
 */
public class GetMaxWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] res = new int[n - 2];
            LinkedList<Integer> qMax = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (qMax.isEmpty()) {
                    qMax.add(arr[i]);
                }
                if (i - qMax.getFirst() > 2) {
                    qMax.removeFirst();
                }
                while (!qMax.isEmpty() && arr[qMax.getLast()] < arr[i]) {
                    qMax.removeLast();
                }
                qMax.add(i);
                if (i >= 2) {
                    res[i - 2] = arr[qMax.getFirst()];
                }
            }
            System.out.println(Arrays.toString(res));
        }
    }
}
