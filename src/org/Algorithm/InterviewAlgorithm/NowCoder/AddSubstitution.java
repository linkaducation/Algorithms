package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/3.
 * 给定两个正整数int a,int b,同时给定一个int type代表运算的类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。
 * 请返回计算的结果，保证数据合法且结果一定在int范围内。
 */
public class AddSubstitution {
	public static int calc(int a, int b, int type) {
		// write code here
		if (type == 1) {
			//乘法
			int count = 0;
			for (int i = 0; i < b; i++) {
				count += a;
			}
			return count;
		} else if (type == 0) {
			//除法
			int count = 0;
			while (count < a) {
				count += b;
			}
			return count;
		} else {
			//减法
			return a + (-b);
		}
	}

	public static void main(String[] args) {
		int calc = calc(1, 2, 1);
		System.out.println(calc);
	}
}
