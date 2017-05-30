package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/30. 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 */
public class MinimumTotal {
	public int minimumTotal(int[][] triangle) {
		// write your code here
		if (triangle == null) {
			return 0;
		}
		int n = triangle.length;
		int[][] array = new int[n][n];
		// 初始化
		array[0][0] = triangle[0][0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					array[i][j] = array[i - 1][j] + triangle[i][j];
				} else if (j == i) {
					array[i][j] = array[i - 1][j - 1] + triangle[i][j];
				} else {
					array[i][j] = Math.min(array[i - 1][j], array[i - 1][j - 1]) + triangle[i][j];
				}
			}
		}
		int best = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			best = Math.min(best, array[n - 1][i]);
		}
		return best;
	}

	public static void main(String[] args) {
		MinimumTotal mm = new MinimumTotal();
		int i = mm.minimumTotal(new int[][] { { 1 }, { 2, 3 } });
		System.out.println(i);
	}
}
