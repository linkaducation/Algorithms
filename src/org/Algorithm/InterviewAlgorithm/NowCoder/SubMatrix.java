package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/10.
 * 有一个方阵，其中每个单元(像素)非黑即白(非0即1)，请设计一个高效算法，找到四条边颜色相同的最大子方阵。
 * 给定一个01方阵mat，同时给定方阵的边长n，请返回最大子方阵的边长。保证方阵边长小于等于100。
 */
public class SubMatrix {

	public int maxSubMatrix(int[][] mat, int n) {
		// write code here

	}

	private int isSquare(int row, int col, int maxRow, int maxCol) {
		if (row >= maxRow || col >= maxCol) {
			return 1;
		}
		int count = 1;
		for (int i = 1; i < maxRow; i++) {

		}
	}
}
