package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/6/25.
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 */
public class TransformImage {

	public int[][] transformImage(int[][] mat, int n) {
		// write code here
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n - j - 1][n - i - 1];
				mat[n - j - 1][n - i - 1] = temp;
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n - i - 1][j];
				mat[n - i - 1][j] = temp;
			}
		}
		return mat;
	}

	public static void main(String[] args) {
		TransformImage tfi = new TransformImage();
		int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		tfi.transformImage(arr, 3);
	}
}
