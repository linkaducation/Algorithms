package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/8/29.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        int res = longestCommonSubsequence("(())()", "((()))");
        System.out.println(res);
    }

    public static int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 ||
                B.length() == 0) {
            return 0;
        }
        char[] s1 = A.toCharArray();
        char[] s2 = B.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[s1.length][s2.length];
    }
}
