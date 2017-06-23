package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 牛牛在研究他自己独创的平衡数，平衡数的定义是：将一个数分成左右两部分，分别成为两个新的数。
 * 左右部分必须满足以下两点：
 * 1，左边和右边至少存在一位。
 * 2，左边的数每一位相乘如果等于右边的数每一位相乘，则这个数称为平衡数。
 * 例如：1221这个数，分成12和21的话，1*2=2*1，则称1221为平衡数，再例如：1236这个数，
 * 可以分成123和1*2*3=6，所以1236也是平衡数。而1234无论怎样分也不满足平衡数。
 */
public class TwoFive {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			boolean flag = true;
			boolean flag2 = true;
			if (n < 10) {
				if (n == 1) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
				flag = false;
				flag2 = false;
			}
			int count = 0;
			if (flag) {
				LinkedList<Integer> list = new LinkedList<>();
				while (n > 0) {
					if (n % 10 == 0) {
						count++;
					}
					list.addFirst(n % 10);
					n = n / 10;
				}
				if (count == 1) {
					System.out.println("NO");
					flag = false;
				} else if (count == 2) {
					System.out.println("YES");
					flag = false;
				}
				int temp = 1;
				for (int i = 0; i < list.size(); i++) {
					temp *= list.get(i);
				}
				int post = 1;
				if (flag) {
					for (int i = 0; i < list.size(); i++) {
						post = post * list.get(i);
						temp = temp / list.get(i);
						if (post == temp) {
							System.out.println("YES");
							flag = false;
							break;
						}
					}
				}
			}
			if (flag && flag2) {
				System.out.println("NO");
			}
		}
	}
}
