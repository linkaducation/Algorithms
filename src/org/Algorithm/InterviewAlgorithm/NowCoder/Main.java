package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            //求和
            int sum1 = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                sum1 += arr[i];
            }
            Set<Integer> set = new HashSet<>();
            int k = in.nextInt();
            int count = 1;
            //把所有的可能存入set
            while (k * count <= sum1) {
                set.add(k * count++);
            }

            int[] dp = new int[n];
            dp[0] = arr[0];
            int maxLen = 0;
            //初始化
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i - 1] + arr[i];
                if (i + 1 > maxLen && set.contains(dp[i])) {
                    maxLen = i + 1;
                }
            }
            for (int i = 1; i < n; i++) {
                dp[i] = arr[i];
                for (int j = n - 1; j >= i + 1 && dp[j] > k; j--) {
                    if (j - i + 1 < maxLen) {
                        break;
                    }
                    dp[j] = dp[j] - arr[i - 1];
                    if (j - i + 1 > maxLen && set.contains(dp[j])) {
                        maxLen = j - i + 1;
                    }
                }
            }
            System.out.println(maxLen);
        }
    }


    //run method
    public void run() {
        Scanner sc = new Scanner(System.in);
        int groupSize = sc.nextInt();
        int[] groups = new int[groupSize];
        int sum = 0;
        for (int i = 0; i < groupSize; i++) {
            groups[i] = sc.nextInt();
            sum += groups[i];
        }
        Arrays.sort(groups);
        if (groups[groupSize - 1] > sum - groups[groupSize - 1]) {
            System.out.println("No");
            return;
        } else {
            System.out.println("Yes");
        }

    }
}