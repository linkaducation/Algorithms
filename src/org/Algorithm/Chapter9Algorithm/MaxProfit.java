package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/9/1.
 */
public class MaxProfit {

    public static void main(String[] args) {
        maxProfit(new int[]{4,4,6,1,1,4,2,5});
    }


    public static void maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return;
        }
        if (prices.length == 1) {
            return;
        }
        int len = prices.length;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = prices[j] - prices[i];
            }
        }
        int[][] res = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                int a = Math.max(dp[i][j], res[i + 1][j]);
                int b = Math.max(res[i][j + 1], res[i + 1][j + 1]);
                res[i][j] = Math.max(a, b);
            }
        }
        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                maxProfit = Math.max(dp[i][j], maxProfit);
                if (j + 1 < len) {
                    maxProfit = Math.max(maxProfit, dp[i][j] + res[j + 1][j + 2]);
                }
            }
        }

//        for (int i = 0; i < len; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
//        System.out.println();
//        for (int i = 0; i < len; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }

        System.out.println(maxProfit);
    }

}
