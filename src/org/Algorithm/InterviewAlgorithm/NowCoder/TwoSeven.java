package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 众所周知计算机代码底层计算都是0和1的计算，牛牛知道这点之后就想使用0和1创造一个新世界！牛牛现在手里有n个0和m个1，
 * 给出牛牛可以创造的x种物品，每种物品都由一个01串表示。牛牛想知道当前手中的0和1可以最多创造出多少种物品。
 */
public class TwoSeven {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int num = in.nextInt();
			int zero = in.nextInt();
			int one = in.nextInt();
			Back[] arr = new Back[num];
			for (int i = 0; i < num; i++) {
				arr[i] = getBack(in.next());
			}
			Back total = new Back(zero, one);
			int[][][] dp = new int[arr.length + 1][arr.length + 1][2];
			for (int i = 0; i < arr.length + 1; i++) {
				dp[0][i][0] = total.zero;
				dp[0][i][0] = total.one;
			}
			for (int i = 0; i < arr.length + 1; i++) {
				dp[i][0][0] = total.zero;
				dp[i][0][0] = total.one;
			}
			for (int i = 1; i <= arr.length; i++) {
				for (int j = 1; j <= arr.length; j++) {
					if ()
				}
			}
		}
	}

	static class Back {
		int zero;
		int one;

		Back(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}
	}

	private static Back getBack(String num) {
		int zero = 0;
		int one = 0;
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) - '0' == 0) {
				zero++;
			}
			if (num.charAt(i) - '0' == 1) {
				one++;
			}
		}
		return new Back(zero, one);
	}
}
