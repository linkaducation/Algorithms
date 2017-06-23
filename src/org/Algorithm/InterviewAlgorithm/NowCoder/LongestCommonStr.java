package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 牛牛有两个字符串（可能包含空格）,牛牛想找出其中最长的公共连续子串,希望你能帮助他,并输出其长度。
 */
public class LongestCommonStr {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		in.useDelimiter("\n");
		while (in.hasNext()) {
			String a = in.nextLine();
			String b = in.nextLine();
			int[][] dp = new int[a.length() + 1][b.length() + 1];
			for (int i = 0; i <= a.length(); i++) {
				dp[i][0] = 0;
			}
			for (int i = 0; i <= b.length(); i++) {
				dp[0][i] = 0;
			}
			for (int i = 1; i <= a.length(); i++) {
				for (int j = 1; j <= b.length(); j++) {
					if (a.charAt(i - 1) == b.charAt(j - 1) || a.charAt(i - 1) == ' ' && b.charAt(j - 1) == ' ') {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
				}
			}
			int max = 0;
			for (int i = 0; i <= a.length(); i++) {
				for (int j = 0; j <= b.length(); j++) {
					max = Math.max(max, dp[i][j]);
				}
			}
			System.out.println(max);
		}
	}
}
