package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/4.
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 */
public class Robot {
	public int countWays(int x, int y) {
		// write code here
		int[][] map = new int[x][y];
		for (int i = 0; i < x; i++) {
			map[i][0] = 1;
		}
		for (int i = 0; i < y; i++) {
			map[0][i] = 1;
		}
		for (int i = 1; i < x; i++) {
			for (int j = 1; j < y; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[x - 1][y - 1];
	}


	/**
	 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
	 * 请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
	 * 给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，
	 * 否则则为障碍。另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，
	 * 为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
	 */

	public int countWays(int[][] map, int x, int y) {
		//初始化
		for (int i = 0; i < x; i++) {
			if (map[i][0] != 1) {
				for (int j = i; j < x; j++) {
					map[j][0] = 0;
				}
				break;
			} else {
				map[i][0] = 1;
			}
		}
		for (int i = 0; i < y; i++) {
			if (map[0][i] != 1) {
				for (int j = i; j < y; j++) {
					map[0][j] = 0;
				}
				break;
			} else {
				map[0][i] = 1;
			}
		}

		for (int i = 1; i < x; i++) {
			for (int j = 1; j < y; j++) {
				if (map[i][j] == 1) {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				} else {
					map[i][j] = 0;
				}
			}
		}
		return map[x - 1][y - 1];
	}


	public static void main(String[] args) {
		Robot robot = new Robot();
		int i = robot.countWays(2, 2);
		System.out.println(i);
	}
}
