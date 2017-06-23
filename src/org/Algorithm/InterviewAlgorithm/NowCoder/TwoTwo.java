package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 牛牛想在[a, b]区间内找到一些数满足可以被一个整数c整除,现在你需要帮助牛牛统计区间内一共有多少个这样的数满足条件？
 */
public class TwoTwo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			long low = in.nextInt();
			long hight = in.nextInt();
			long key = in.nextInt();
			int count = 0;
			long k;
			if (low != 0) {
				k = low / key;
			} else {
				count++;
				k = 1;
			}
			long temp = key;
			while (temp <= hight) {
				temp = key * k;
//				key = key * k;
				if (temp >= low && temp <= hight) {
					count++;
				}
				k++;
			}
			System.out.println(count);
		}
	}
}
