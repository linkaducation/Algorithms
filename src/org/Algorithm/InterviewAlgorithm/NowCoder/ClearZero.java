package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.HashSet;

/**
 * Created by Ellen on 2017/6/25.
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 */
public class ClearZero {

	public int[][] clearZero(int[][] mat, int n) {
		// write code here
		HashSet<Integer> row = new HashSet<>();
		HashSet<Integer> col = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (row.contains(i) && col.contains(j)) {
					for (int k = 0; k < n; k++) {
						mat[i][k] = 0;
						mat[k][j] = 0;
					}
				}
			}
		}
		return mat;
	}

	public static void main(String[] args) {
		ClearZero cz = new ClearZero();
		int[][] arr = new int[][]{{1, 2, 3, 2}, {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 0, 1, 1,}};
		int[][] mat = cz.clearZero(arr, 4);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
