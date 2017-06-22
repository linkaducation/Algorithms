package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/22.
 * 牛牛定义排序子序列为一个数组中一段连续的子序列,并且这段子序列是非递增或者非递减排序的。
 * 牛牛有一个长度为n的整数数组A,他现在有一个任务是把数组A分为若干段排序子序列,
 * 牛牛想知道他最少可以把这个数组分为几段排序子序列.
 * 如样例所示,牛牛可以把数组A划分为[1,2,3]和[2,2,1]两个排序子序列,至少需要划分为2个排序子序列,所以输出2
 * 6
 * 1 2 3 2 2 1
 */
public class DivideArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int cnt = 1;
		for (int i = 1; i < n - 1; i++) {
			if (a[i] > a[i - 1] && a[i] > a[i + 1] || a[i] < a[i - 1] && a[i] < a[i + 1]) {
				cnt++;
				if (n - 3 != i) {
					i++;
				}
			}
		}
		System.out.println(cnt);
	}
}
