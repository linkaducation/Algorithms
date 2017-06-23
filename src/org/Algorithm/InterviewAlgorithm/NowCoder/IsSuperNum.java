package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 如果一个数字能表示为p^q(^表示幂运算)且p为一个素数,q为大于1的正整数就称这个数叫做超级素数幂。
 * 现在给出一个正整数n,如果n是一个超级素数幂需要找出对应的p,q。
 */
public class IsSuperNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int最大范围为2^32.远远小于10^18.故用long.long的范围为2^64
		while (sc.hasNext()) {

			long num = sc.nextLong();
			double p;
			boolean flag = false;
			for (long q = 2; q * q <= num; q++) {
				p = Math.pow((double) num, 1d / q);
				//(long)p == p 判断p经过 Math.pow((double) num, 1d/q)后是否为整数
				if ((long) p == p && isPrimeNumber((long) p)) {
					System.out.println((long) p + " " + q);
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("No");
			}
		}
	}

	/**
	 * 判断是否为素数
	 *
	 * @param n 输入long值
	 * @return true素数 false 不是素数
	 */
	public static boolean isPrimeNumber(long n) {
		if (n <= 1) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}
