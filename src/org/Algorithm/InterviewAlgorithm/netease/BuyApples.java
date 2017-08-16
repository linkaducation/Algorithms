package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/16.
 */
public class BuyApples {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            //购买i个苹果最少的袋子数
            int[] arr = new int[n + 1];
            for (int i = 6; i <= n; i++) {
                arr[i] = Integer.MAX_VALUE;
            }
            if (n >= 6) {
                arr[6] = 1;
                if (n >= 8) {
                    arr[8] = 1;
                }
            }
            for (int i = 6; i <= n; i++) {
                if (arr[i] == Integer.MAX_VALUE)
                    continue;
                if (i + 6 <= n && arr[i + 6] > arr[i] + 1) {
                    arr[i + 6] = arr[i] + 1;
                }
                if (i + 8 <= n && arr[i + 8] > arr[i] + 1) {
                    arr[i + 8] = arr[i] + 1;
                }
            }
            int res = arr[n];
            if (arr[n] == Integer.MAX_VALUE) {
                res = -1;
            }
            System.out.println(res);
        }
    }
}
