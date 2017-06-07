package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/6/7. 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
	public int movingCount(int threshold, int rows, int cols) {
		boolean[][] visited = new boolean[rows][cols];
		int count = getCount(threshold, rows, cols, 0, 0, visited);
		return count;
	}

	private int getCount(int thresshold, int rows, int cols, int r, int c, boolean[][] visited) {
		if (r < 0 || r >= rows || c < 0 || c >= cols || !isThere(thresshold, r, c) || visited[r][c]) {
			return 0;
		}
		visited[r][c] = true;
		return getCount(thresshold, rows, cols, r - 1, c, visited)
                + getCount(thresshold, rows, cols, r + 1, c, visited)
				+ getCount(thresshold, rows, cols, r, c - 1, visited)
				+ getCount(thresshold, rows, cols, r, c + 1, visited) + 1;
	}

	private boolean isThere(int thresshold, int i, int j) {
		int sum = 0;
		do {
			sum += i % 10;
		} while ((i = i / 10) > 0);
		do {
			sum += j % 10;
		} while ((j = j / 10) > 0);
		if (sum <= thresshold) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		MovingCount mc = new MovingCount();
		int count = mc.movingCount(15, 20, 20);
		System.out.println(count);
	}
}
