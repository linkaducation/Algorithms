package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/30. "不同的路径" 的跟进问题： 现在考虑网格中有障碍物，那样将会有多少条不同的路径？ 网格中的障碍和空位置分别用 1 和 0 来表示。
 */
public class UniquePathsWithObstacles {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// write your code here
		if (obstacleGrid == null) {
			return 0;
		}
		int m = obstacleGrid[0].length;
		int n = obstacleGrid.length;
		int[][] array = new int[n][m];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[0][i] == 1) {
				for (int j = i; j < m; j++) {
					array[0][j] = 0;
				}
				break;
			} else {
				array[0][i] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[i][0] == 1) {
				for (int j = i; j < n; j++) {
					array[j][0] = 0;
				}
				break;
			} else {
				array[i][0] = 1;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (obstacleGrid[i][j - 1] == 1) {
					if (obstacleGrid[i - 1][j] == 1) {
						array[i][j] = 0;
					} else {
						array[i][j] = array[i - 1][j];
					}
				} else {
					if (obstacleGrid[i - 1][j] == 1) {
						array[i][j] = array[i][j - 1];
					} else {
						array[i][j] = array[i - 1][j] + array[i][j - 1];
					}
				}
			}
		}
		if (obstacleGrid[n - 1][m - 1] == 1) {
		    return 0;
        }
		return array[n - 1][m - 1];
	}
}
