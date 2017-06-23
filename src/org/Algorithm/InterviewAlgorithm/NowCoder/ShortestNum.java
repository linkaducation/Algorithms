package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。
 * 答案可能有多个，我我们需要找出长度最小的那个。
 * 例如 N = 18 L = 2：
 * 5 + 6 + 7 = 18
 * 3 + 4 + 5 + 6 = 18
 * 都是满足要求的，但是我们输出更短的 5 6 7
 */
public class ShortestNum {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			boolean flag = true;
			for (int i = L; i <= 100; i++) {
				if ((2 * N + i - i * i) % (2 * i) == 0) {
					int start = (2 * N + i - i * i) / (2 * i);
					for (int j = 0; j < i - 1; j++) {
						System.out.print(start + j + " ");
					}
					System.out.print(start + i - 1);
					flag = false;
					break;
				}
				if (!flag) {
					break;
				}
			}
			if (flag) {
				System.out.print("No");
			}
		}
	}
}
