package org.Algorithm.BackPack;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/25.
 * 完全背包问题，物品可以很多件，刚好使空间填满，求解一共有多少种方案
 */
public class FullBackPack {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();//物品数
			int m = in.nextInt();//背包总量
			int[] stuff = new int[n];
			for (int i = 0; i < n; i++) {
				stuff[i] = in.nextInt();
			}
			int[][] dp = new int[n + 1][m + 1];

		}
	}
}
