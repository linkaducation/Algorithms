package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/30. 给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
 */
public class MinPathSum {
	public int minPathSum(int[][] grid) {
		// write your code here
		if (grid.length <= 0) {
			return 0;
		}
		int m = grid[0].length;
        int n = grid.length;
        int[][] array = new int[n][m];
		array[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			array[0][i] = grid[0][i] + array[0][i - 1];
		}
		for (int i = 1; i < n; i++) {
			array[i][0] = grid[i][0] + array[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				array[i][j] = Math.min(array[i - 1][j], array[i][j - 1]) + grid[i][j];
			}
		}
		return array[n - 1][m - 1];
	}

	public static void main(String[] args) {
		MinPathSum mp = new MinPathSum();
		int i = mp.minPathSum(new int[][] { { 1, 4, 8, 6, 2, 2, 1, 7 }, { 4, 7, 3, 1, 4, 5, 5, 1 },
				{ 8, 8, 2, 1, 1, 8, 0, 1 }, { 8, 9, 2, 9, 8, 0, 8, 9 }, { 5, 7, 5, 7, 1, 8, 5, 5 },
				{ 7, 0, 9, 4, 5, 6, 5, 6 }, { 4, 9, 9, 7, 9, 1, 9, 0 } });
		System.out.println(i);
	}
}
