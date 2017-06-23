package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 牛牛手里有N根木棒,分别编号为1~N,现在他从N根里想取出三根木棒，使得三根木棒构成一个三角形,
 * 你能计算出牛牛有多少种取法吗?(考虑两种取法中使用的木棒编号有一个不一样就认为是不同的取法)。
 */
public class TwoThree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			int[][] dp = new int[arr.length][arr.length];
			int count = 0;
			for (int i = 0; i < arr.length - 2; i++) {
				for (int j = i + 2; j < arr.length; j++) {
					dp[i][j] = arr[i] + arr[j - 1];
					if (dp[i][j] > arr[j]) {
						for (int k = j; k < arr.length; k++) {
							if (dp[i][j] > arr[k]) {
								count++;
							} else {
								break;
							}
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}
