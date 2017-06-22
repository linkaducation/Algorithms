package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/22.
 * 牛牛现在有一个n个数组成的数列,牛牛现在想取一个连续的子序列,并且这个子序列还必须得满足:最多只改变一个数,
 * 就可以使得这个连续的子序列是一个严格上升的子序列,牛牛想知道这个连续子序列最长的长度是多少。
 */
public class LongestQueue {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int[] dp1 = new int[n];//以第i个开始的最长上升序列
		int[] dp2 = new int[n];//以第i个结尾的最长上升序列
		dp2[0] = 1;
		for (int i = 1; i <= n - 1; i++) {
			if (arr[i] > arr[i - 1]) {
				dp2[i] = dp2[i - 1] + 1;
			} else {
				dp2[i] = 1;
			}
		}

		dp1[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i + 1] > arr[i]) {
				dp1[i] = dp1[i + 1] + 1;
			} else {
				dp1[i] = 1;
			}
		}
		int ret = 0;
		int m = 1;
		for (int i = 0; i < n - 1; ++i)
		{
			if (i == 0)
				m = dp1[i + 1] + 1;
			else if (i == n - 1)
				m = dp2[i - 1] + 1;
			else if (arr[i - 1] + 1 < arr[i + 1])
				m = dp1[i + 1] + dp2[i - 1] + 1;
			else
				m = Math.max(dp1[i + 1], dp2[i - 1]) + 1;
			if (m > ret)
				ret = m;
		}
		System.out.println(ret);
	}
}
