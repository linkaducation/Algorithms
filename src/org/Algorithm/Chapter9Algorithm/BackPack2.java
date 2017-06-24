package org.Algorithm.Chapter9Algorithm;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/24.
 * 给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大
 */
public class BackPack2 {
	public int backPackII(int m, int[] A, int V[]) {
		// write your code here
		if (A == null || V == null || A.length <= 0 || V.length <= 0) {
			return 0;
		}
		int[][] dp = new int[A.length + 1][m + 1];
		for (int i = 0; i < m + 1; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i < A.length + 1; i++) {
			for (int j = 1; j <= m; j++) {
				if (j + A[i - 1] <= m) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + A[i - 1]] + V[i - 1]);
				}
			}
		}
		int max = 0;
		for (int i = m; i >= 0; i--) {
			max = Math.max(max, dp[A.length][i]);
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int m = in.nextInt();
			int[] A = new int[8];
			int[] V = new int[8];
			for (int i = 0; i < 8; i++) {
				A[i] = in.nextInt();
			}
			for (int i = 0; i < 8; i++) {
				V[i] = in.nextInt();
			}
			int[][] dp = new int[A.length + 1][m + 1];
			for (int i = 0; i < m + 1; i++) {
				dp[0][i] = 0;
			}
			for (int i = 1; i < A.length + 1; i++) {
				for (int j = m; j >= A[i - 1]; j--) {
					if (dp[i - 1][j] < dp[i - 1][j - A[i - 1]] + V[i - 1]) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
					}
				}
			}
			System.out.println(dp[A.length][m]);
			//100 77 22 29 50 99 92 22 87 46 90
			//200 79 58 86 11 28 62 15 68 83 14 54 79 72 52 48 62

		}
	}
}
