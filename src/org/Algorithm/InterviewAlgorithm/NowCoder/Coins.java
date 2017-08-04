package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/4.
 * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。
 * 给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
 */
public class Coins {
	//动态规划
	public int countWays(int n) {
		// write code here
		int[][] dp = new int[4][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		int[] coins = new int[]{1, 5, 10, 25};
		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < n; j++) {
				if (j >= )
			}
		}
	}
}
