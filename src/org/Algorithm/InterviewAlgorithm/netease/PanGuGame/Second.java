package org.Algorithm.InterviewAlgorithm.netease.PanGuGame;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/25.
 * 在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值
 */
public class Second {

	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int d = in.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = in.nextInt();
				}
			}

			//统计每行
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - d; j++) {
					getMaxPath(arr, j, i, d);
				}
			}

			//统计每行
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - d; j++) {
					getMaxPath3(arr, i, j, d);
				}
			}

			//统计斜着的

		}
	}

	//统计行
	private static void getMaxPath(int[][] arr,int col, int row, int d) {
		int temp = 0;
		for (int i = 0; i < d; i++) {
			temp+=arr[row][col++];
		}
		max = Math.max(max, temp);
	}

	//统计行
	private static void getMaxPath3(int[][] arr,int col, int row, int d) {
		int temp = 0;
		for (int i = 0; i < d; i++) {
			temp+=arr[row++][col];
		}
		max = Math.max(max, temp);
	}

	//统计倾斜
	private static void getMaxPath2(int[][] arr,int col, int row, int d, int n) {
		int temp = 0;
		for (int i = col; i < d; i++) {
			if (row >= n || i >= n) {
			}
			temp+=arr[row++][i];
		}
		max = Math.max(max, temp);
	}

}
