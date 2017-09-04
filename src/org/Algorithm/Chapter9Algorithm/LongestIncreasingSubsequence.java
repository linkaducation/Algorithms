package org.Algorithm.Chapter9Algorithm;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ellen on 2017/6/11. 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 */
public class LongestIncreasingSubsequence {
	public int longestIncreasingSubsequence(int[] nums) {
		// write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
		int[] f = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			f[i] = 1;
		}
		for (int i = 0; i < nums.length; i++) {
			f[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}
		int result = 1;
		for (int i = 0; i < f.length; i++) {
			result = Math.max(result, f[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		ConcurrentHashMap
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int i = lis.longestIncreasingSubsequence(new int[] { 1, 2, 7, 4, 5, 6 });
		System.out.println(i);
	}
}
