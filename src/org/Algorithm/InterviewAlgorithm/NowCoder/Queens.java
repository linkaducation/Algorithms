package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/7.
 * 请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个nxn的棋盘上放置n个棋子，
 * 使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。
 * 给定一个int n，请返回方法数，保证n小于等于15
 */
public class Queens {

	public static void main(String[] args) {
		int i = nQueens(5);
		System.out.println(i);
	}

	public static int nQueens(int n) {
		// write code here
		int[] cols = new int[n];
		int[] num = {0};
		for (int i = 0; i < n; i++) {
			cols[0] = i;//第一行皇后的位置 
			getCount(cols, 1, num);
		}
		return num[0];
	}

	public static void getCount(int[] cols, int row, int[] num) {
		if (row == (cols.length)) {
			num[0]++;
			return;
		}
		for (int i = 0; i < cols.length; i++) {
			if (checkValid(cols, row, i)) {
				cols[row] = i;
				getCount(cols, row + 1, num);
			}
		}
	}

	private static boolean checkValid(int[] cols, int row, int col) {
		for (int i = 0; i < row; i++) {
			int temp = cols[i];
			if (temp == col) {
				return false;
			}
			if (Math.abs(row - i) == Math.abs(temp - col)) {
				return false;
			}
		}
		return true;
	}
}
