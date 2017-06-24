package org.Algorithm.InterviewAlgorithm.MeiTuan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/24.
 * 给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，
 * 编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数
 */
public class Second {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] arr = new int[]{1, 5, 10, 20, 50, 100};
			boolean[][] dp = new boolean[7][n + 1];
			Arrays.fill(dp[1], true);
			int count = 1;
			for (int i = 2; i <= 6; i++) {
				for (int j = 0; j <= n; j++) {
					dp[i][j] = dp[i - 1][j];
					if (dp[i][j]) {
						for (int k = 1; k * arr[i - 1] + j <= n; k++) {
							if (arr[i - 1] * k + j <= n) {
								dp[i][j + arr[i - 1] * k] = true;
							}
							if (arr[i - 1] * k + j == n) {
								count++;
							}
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}
