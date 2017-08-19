package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] group = new int[n];
            for (int i = 0; i < n; i++) {
                group[i] = in.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = group[0];
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i - 1] + group[i];
            }
            int q = in.nextInt();
            int[] qi = new int[q];
            for (int i = 0; i < q; i++) {
                qi[i] = in.nextInt();
            }
            int[] res = new int[q];
            for (int i = 0; i < q; i++) {
                int count = 1;
                while (qi[i] > dp[count - 1]) {
                    count++;
                }
                res[i] = count;
            }
            for (int i = 0; i < q; i++) {
                System.out.println(res[i]);
            }
        }
    }
}

