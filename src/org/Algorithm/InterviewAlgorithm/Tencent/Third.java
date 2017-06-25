package org.Algorithm.InterviewAlgorithm.Tencent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/25.
 * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
 * 如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
 */
public class Third {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 2; i < n + 1; i++) {
				if (isZ(i)) {
					list.add(i);
				}
			}
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				for (int j = i; j < list.size(); j++) {
					if (list.get(i) + list.get(j) == n) {
						count++;
						break;
					}
					if (list.get(i) + list.get(j) > n) {
						break;
					}
				}
			}
			System.out.println(count);
		}
	}

	private static boolean isZ(int n) {
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
