package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/30. 有一个机器人的位于一个 m × n 个网格左上角。
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * 问有多少条不同的路径？
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		// write your code here
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] array = new int[n][m];
        for (int i = 0; i < m; i++) {
            array[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            array[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[n - 1][m - 1];
    }
}
