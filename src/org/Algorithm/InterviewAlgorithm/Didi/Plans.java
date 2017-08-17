package org.Algorithm.InterviewAlgorithm.Didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class Plans {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            long[][] dp = new long[n + 1][m + 1];
            Arrays.fill(dp[0], 0);
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= arr[i - 1]) {
                        dp[i][j] += dp[i - 1][j - arr[i - 1]];
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }

}
