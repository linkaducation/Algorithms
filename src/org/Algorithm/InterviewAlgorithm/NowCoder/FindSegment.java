package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/7.
 * 有一个整数数组，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，
 * 整个数组就是有序的。注意：n-m应该越小越好，也就是说，找出符合条件的最短序列。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的起点和终点。
 * (原序列位置从0开始标号,若原序列有序，返回[0,0])。保证A中元素均为正整数。  1 2 3 6 7 11 4 0 9 10 13
 */
public class FindSegment {
	public static int[] findSegment(int[] A, int n) {
		// write code here
		int[] temp = new int[n];
		temp[0] = A[0];
		int max = 0;
		int min = 9999;
		for (int i = 1; i < n; i++) {
			temp[i] = Math.max(temp[i - 1], A[i]);
		}
		for (int i = n - 1; i >= 0; i--) {
			if (temp[i] > A[i]) {
				max = i;
				break;
			}
		}
		Arrays.fill(temp, 0);
		temp[n - 1] = A[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			temp[i] = Math.min(temp[i + 1], A[i]);
		}
		for (int i = 0; i < n; i++) {
			if (A[i] > temp[i]) {
				min = i;
				break;
			}
		}
		return new int[]{min == 9999 ? 0 : min, max};
	}

	public static void main(String[] args) {
		int[] segment = findSegment(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}, 13);
		System.out.println(segment[0] + " ：" + segment[1]);
	}
}
