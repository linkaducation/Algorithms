package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/28.
 */
public class GetMoneyAmount {

    public static void main(String[] args) {
        int res = getMoneyAmount(10);
        System.out.println(res);
    }

    public static int getMoneyAmount(int n) {
        // Write your code here
        int[][] table = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int localMax = k + Math.max(table[i][k - 1], table[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i + 1 == j ? i : globalMin;
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(table[i]));
        }
        return table[1][n];
    }
}
