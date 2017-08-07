package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/7.
 * 有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。
 * 请设计一个高效的算法，计算给定数组中的逆序对个数。
 * 给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。
 */
public class AntiOrder {

	public static int count(int[] A, int n) {
		// write code here
		int[] dp = new int[n];
		dp[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			dp[i] = 0;
			for (int j = n - 1; j > i ; j--) {
				if (A[i] > A[j]) {
					dp[i] += 1;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res += dp[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int count = count(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 5}, 9);
		System.out.println(count);
	}
}
