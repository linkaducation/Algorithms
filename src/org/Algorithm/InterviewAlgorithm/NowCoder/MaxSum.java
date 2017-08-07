package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/7.
 * 对于一个有正有负的整数数组，请找出总和最大的连续数列。
 * 给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
 */
public class MaxSum {

	public static int getMaxSum(int[] A, int n) {
		// write code here
		int[] dp = new int[n];
		dp[0] = A[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
		}
		System.out.println(Arrays.toString(dp));
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int maxSum = getMaxSum(new int[]{-1}, 1);
		System.out.println(maxSum);
	}
}
