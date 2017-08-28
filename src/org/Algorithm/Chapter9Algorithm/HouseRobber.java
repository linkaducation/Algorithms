package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/8/28.
 */
public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(houseRobber(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public static long houseRobber(int[] A) {
        // write your code here
        int len = A.length;
        if (len <= 1) {
            return A[0];
        }
        long[] dp = new long[len];
        dp[0] = A[0];
        dp[1] = A[1];
        for (int i = 2; i < len; i++) {
            dp[i] = dp[i - 2] + A[i];
        }
        return dp[len - 1] > dp[len - 2] ? dp[len - 1] : dp[len - 2];
    }
}
