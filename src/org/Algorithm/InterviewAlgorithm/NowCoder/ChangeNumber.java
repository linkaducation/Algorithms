package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/22.
 * 牛牛想对一个数做若干次变换，直到这个数只剩下一位数字。
 * 变换的规则是：将这个数变成 所有位数上的数字的乘积。比如285经过一次变换后转化成2*8*5=80.
 * 问题是，要做多少次变换，使得这个数变成个位数。
 */
public class ChangeNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int trans = 0;
			while (n > 10) {
				int temp = 1;
				while (n > 0) {
					temp = temp * (n % 10);
					n = n / 10;
				}
				n = temp;
				trans++;
			}
			System.out.println(trans);
		}
	}
}
