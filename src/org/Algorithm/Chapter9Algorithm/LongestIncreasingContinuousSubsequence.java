package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/30. 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 */
public class LongestIncreasingContinuousSubsequence {
	public int longestIncreasingContinuousSubsequence(int[] A) {
		// Write your code here
		if (A == null || A.length <= 0) {
			return 0;
		}
		if (A.length == 1) {
			return 1;
		}
		int[] array = new int[A.length];
		int[] array1 = new int[A.length];
		array[0] = 1;
		array1[0] = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				array[i] = array[i - 1] + 1;
			} else {
				array[i] = 1;
			}
		}
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				array1[i] = array1[i - 1] + 1;
			} else {
				array1[i] = 1;
			}
		}
		int best = 0;
		for (int i = 0; i < array.length; i++) {
			best = Math.max(best, array[i]);
		}
		int best1 = 0;
		for (int i = 0; i < array1.length; i++) {
			best1 = Math.max(best1, array1[i]);
		}
		return Math.max(best, best1);
	}

	public static void main(String[] args) {
		LongestIncreasingContinuousSubsequence lc = new LongestIncreasingContinuousSubsequence();
		int i = lc.longestIncreasingContinuousSubsequence(new int[] { 5, 4, 2, 1, 3 });
		System.out.println(i);
	}
}
