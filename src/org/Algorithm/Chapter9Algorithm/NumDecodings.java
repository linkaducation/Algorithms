package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/27.
 * 有一个消息包含A-Z通过以下规则编码
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 现在给你一个加密过后的消息，问有几种解码的方式
 * <p>
 * 动态规划：1.如果arr[i] > 6 || arr[i - 1] > 2 || arr[i - 1] == 0 || arr[i] == 0:
 * dp[i] = dp[i - 1]
 * 2.如果arr[i] >= 0 && arr[i] <= 6 && arr[i - 1] > 0 && arr[i - 1] <= 2
 * dp[i] = dp[i - 1] + dp[i - 2]
 */
public class NumDecodings {

    public static void main(String[] args) {
        int i = numDecodings("0");
        System.out.println(i);
    }

    public static int numDecodings(String s) {
        // write your code here
        char[] arr = s.toCharArray();
        if (arr.length <= 0) {
            return 0;
        }
        if (arr.length == 1 && arr[0] != '0') {
            return 1;
        }
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 1;
        if (arr[0] == '0' || (arr[1] == '0' && arr[0] > '2')) {
            return 0;
        }
        if (arr[0] == '1' && arr[1] <= '9' && arr[1] >= '1') {
            dp[1] = 2;
        } else if (arr[0] == '2' && arr[1] <= '6' && arr[1] > '0') {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < len; i++) {
            if (arr[i] == '0') {
                if (arr[i - 1] == '0' || arr[i - 1] > '2') {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                if (arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] <= '6')) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[len - 1];
    }
}
