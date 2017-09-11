package org.Algorithm.InterviewAlgorithm.Didi;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/9/10.
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = arr[0] == 0 ? 1 : 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] == 0) {
                    dp[i] = dp[i - 1] + 1;
                    continue;
                } else {
                    dp[i] = dp[i - 1];
                }
                int tem = arr[i];
                for (int j = i - 1; j >= 0; j--) {
                    tem ^= arr[j];
                    if (tem == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        break;
                    }
                }
            }
            System.out.println(dp[n - 1]);
        }
    }
}