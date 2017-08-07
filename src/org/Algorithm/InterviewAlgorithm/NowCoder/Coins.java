package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/4.
 * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。
 * 给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
 */
public class Coins {
	//动态规划
	public static int countWays(int n) {
		// write code here
		int[] coins = new int[]{1, 5, 10, 25};
		//初始化
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = coins[i]; j <= n; j++) {
				dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int i = countWays(20);
		System.out.println(i);
	}
}
