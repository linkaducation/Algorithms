package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/21.
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，
 * 假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
 * n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，
 * 求这个最小的时间
 */
public class DoubleCore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int g1 = 0, g2 = 0;
            for (int i = n - 1; i > 0; i--) {
                if (g1 < g2) {
                    g1 += arr[i];
                } else {
                    g2 += arr[i];
                }
            }
            System.out.println(Math.max(g1, g2));
        }
    }
}
