package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 众所周知计算机代码底层计算都是0和1的计算，牛牛知道这点之后就想使用0和1创造一个新世界！牛牛现在手里有n个0和m个1，
 * 给出牛牛可以创造的x种物品，每种物品都由一个01串表示。牛牛想知道当前手中的0和1可以最多创造出多少种物品。
 */
public class TwoSeven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int x = sc.nextInt(); //物品数
			int n = sc.nextInt(); //0
			int m = sc.nextInt(); //1
			int[] zero = new int[x];
			int[] one = new int[x];
			String item;
			for(int i=0;i<x;i++) {
				item = sc.next();
				int cnt = 0;
				for(int j=0;j<item.length();j++) {
					if(item.charAt(j) == '0') {
						cnt++;
					}
				}
				zero[i] = cnt;
				one[i] = item.length()-cnt;
			}
			int[][] dp = new int[n+1][m+1];
			for(int i=0;i<x;i++) {
				for(int j=n;j>=zero[i];j--) {
					for(int k=m;k>=one[i];k--) {
						if(dp[j][k] < dp[j-zero[i]][k-one[i]]+1) {
							dp[j][k] = dp[j-zero[i]][k-one[i]]+1;
						}
					}
				}
			}
			System.out.println(dp[n][m]);
		}
	}
}
