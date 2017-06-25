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
			long[][] dp = new long[arr.length][n + 1];
			Arrays.fill(dp[0], 1);
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j <= n; j++) {
					for (int k = 0; k * arr[i] <= j; k++) {
						dp[i][j] = dp[i][j] + dp[i - 1][j - k * arr[i]];
					}
				}
			}
			System.out.println(dp[arr.length - 1][n]);
		}
	}
}
