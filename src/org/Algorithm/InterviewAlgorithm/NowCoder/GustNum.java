package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。
 * 牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。例如：
 * 10 7 12 8 11 那么抹除掉的整数只可能是9
 * 5 6 7 8 那么抹除掉的整数可能是4也可能是9
 */
public class GustNum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			int i = 1;
			boolean flag = true;
			int f = 0;
			for (; i < n; i++) {
				if (arr[i] > arr[i - 1] + 1) {
					if (f != 0 || arr[i - 1] + 2 < arr[i]) {
						System.out.println("mistake");
						flag = false;
						break;
					}
					if (arr[i - 1] + 2 == arr[i]) {
						f = arr[i] - 1;
					}
				}
			}
			if (flag && f == 0) {
				if (arr[0] - 1 != 0) {
					System.out.print(arr[0] - 1 + " ");
				}
				System.out.println(arr[arr.length - 1] + 1);
			} else if (f != 0 && flag){
				System.out.println(f);
			}
		}
	}
}
