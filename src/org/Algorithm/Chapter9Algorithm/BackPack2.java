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
		int[] dp = new int[m + 1];
		for (int i = 0; i <= m; i++) {
			dp[i] = 0;
		}
		for (int i = 0; i < 8; i++) {
			for (int j = m; j >= A[i]; j--) {
				if (dp[j] < dp[j - A[i]] + V[i]) {
					dp[j] = dp[j - A[i]] + V[i];
				}
			}
		}
		return dp[m];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int m = in.nextInt();
			int len = in.nextInt();
			int[] A = new int[len];
			int[] V = new int[len];
			for (int i = 0; i < len; i++) {
				A[i] = in.nextInt();
			}
			for (int i = 0; i < len; i++) {
				V[i] = in.nextInt();
			}
			int[] dp = new int[m + 1];

			//求最大总价值初始化为0，求刚好装满的最大总价值初始化为负无穷
			for (int i = 0; i <= m; i++) {
				dp[i] = -Integer.MAX_VALUE;
			}
			dp[0] = 0;
			for (int i = 0; i < len; i++) {
				for (int j = m; j >= A[i]; j--) {
					if (dp[j] < dp[j - A[i]] + V[i]) {
						dp[j] = dp[j - A[i]] + V[i];
					}
				}
			}
			System.out.println(dp[m]);
			//100 77 22 29 50 99 92 22 87 46 90
			//200 79 58 86 11 28 62 15 68 83 14 54 79 72 52 48 62

		}
	}
}
