package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/6/15. 给定n个不同的正整数，整数k（k < = n）以及一个目标数字。 在这n个数里面找出K个数，使得这K个数的和等于目标数字，求问有多少种方案
 */
public class KSum {
	public int kSum(int[] A, int k, int target) {
		// write your code here
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    f[i][j][t] = 0;
                    if (t >= A[i - 1]) {
                        f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];
                    }
                    f[i][j][t] += f[i - 1][j][t];
                } // for t
            } // for j
        } // for i
        return f[n][k][target];

    }
}
