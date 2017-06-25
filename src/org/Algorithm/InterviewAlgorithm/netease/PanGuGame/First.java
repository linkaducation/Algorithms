package org.Algorithm.InterviewAlgorithm.netease.PanGuGame;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/25.
 * 给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。
 * 比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。
 */
public class First {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String s = in.next();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); ) {
				int temp = 1;
				while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
					temp++;
					i++;
				}
				sb.append(temp + String.valueOf(s.charAt(i++)));
			}
			System.out.println(sb.toString());
		}
	}
}
