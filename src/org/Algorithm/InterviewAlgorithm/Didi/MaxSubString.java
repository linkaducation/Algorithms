package org.Algorithm.InterviewAlgorithm.Didi;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class MaxSubString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = arr[0];
            int res = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            }
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dp[i]);
            }
            System.out.println(res);
        }
    }
}
