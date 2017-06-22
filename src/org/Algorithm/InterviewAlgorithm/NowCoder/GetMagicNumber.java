package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/22.
 * 给出一个区间[a, b]，计算区间内“神奇数”的个数。
 * 神奇数的定义：存在不同位置的两个数位，组成一个两位数（且不含前导0），且这个两位数为质数。
 * 比如：153，可以使用数字3和数字1组成13，13是质数，满足神奇数。
 * 同样153可以找到31和53也为质数，只要找到一个质数即满足神奇数。
 */
public class GetMagicNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int low = in.nextInt();
			int hight = in.nextInt();
			int count = 0;
			boolean flag = true;
			while (low <= hight) {
				int len = String.valueOf(low).length();
				int[] num = new int[len];
				int temp = low;
				for (int j = 0; j < len; j++) {
					num[j] = temp % 10;
					temp = temp / 10;
				}
				for (int j = 0; j < num.length; j++) {
					for (int k = j + 1; k < num.length; k++) {
						if (isMagic(num[j], num[k]) || isMagic(num[k], num[j])) {
							count++;
							flag = false;
							break;
						}
					}
					if (!flag) {
						flag = true;
						break;
					}
				}
				low = low + 1;
			}
			System.out.println(count);
		}

	}

	private static boolean isMagic(int pre, int post) {
		if (pre == 0) {
			return false;
		}
		int num = pre * 10 + post;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
