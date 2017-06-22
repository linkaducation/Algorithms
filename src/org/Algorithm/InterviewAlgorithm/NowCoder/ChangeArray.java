package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/22.
 * 牛牛有一个数组，里面的数可能不相等，现在他想把数组变为：所有的数都相等。问是否可行。
 * 牛牛可以进行的操作是：将数组中的任意一个数改为这个数的两倍。
 * 这个操作的使用次数不限，也可以不使用，并且可以对同一个位置使用多次。
 */
public class ChangeArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int[] arr = new int[n];
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				list.add(arr[i]);
			}
			if (list.contains(2) && list.contains(3)) {
				System.out.println("NO");
				break;
			}
			Arrays.sort(arr);
			boolean flag = true;
			int length = arr.length - 1;
			while (arr[length] < 1e9) {
				int i;
				for (i = length - 1; i >= 0; i--) {
					if (arr[length] % arr[i] != 0) {
						arr[length] *= 2;
						break;
					}
				}
				if (i <= 0) {
					System.out.println("YES");
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("NO");
			}
		}
	}
}
