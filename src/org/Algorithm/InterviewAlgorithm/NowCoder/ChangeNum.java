package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/22.
 * 输入两个字符串A,B，找出A在B中最长连续对应相等的位数；
 */
public class ChangeNum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String A = in.next();
			String B = in.next();
			int count;
			int max = 0;
			for (int i = 0; i <= B.length() - A.length(); i++) {
				count = 0;
				for (int j = 0; j < A.length(); j++) {
					if (A.charAt(j) == B.charAt(i + j)) {
						count++;
					}
					max = Math.max(max, count);
				}
			}
			System.out.println(A.length() - max);
		}
	}
}
