package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/7.
 * 约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。然后由第一个人开始报数，数到m的人出局。
 * 现在需要求的是最后一个出局的人的编号。
 * 给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000
 */
public class Joseph {

	public static void main(String[] args) {
		int result = getResult(5, 6);
		System.out.println(result);
	}

	public static int getResult(int n, int m) {
		// write code here
		boolean[] isAlive = new boolean[n];
		Arrays.fill(isAlive, true);
		int start = 0;//当前位置
		int count = 0;//死亡总数
		int dead = 1;//报数大小
		while (count < n - 1) {
			if (dead == m) {
				//当前位置的人死掉，死亡总数加一，报数归一，起始位置为下一个存活的人
				isAlive[start] = false;
				count++;
				dead = 1;
				while (!isAlive[start]) {
					start++;
					if (start > n - 1) {
						start = 0;
					}
				}
			} else if (isAlive[start]) {
				//正常报数：当前位置加一，报数大小加一
				start++;
				if (start > n - 1) {
					start = 0;
				}
				while (!isAlive[start]) {
					start++;
					if (start > n - 1) {
						start = 0;
					}
				}
				dead++;
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (isAlive[i]) {
				res = i;
				break;
			}
		}
		return res;
	}


	/**
	 * 约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。
	 * 然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。接着第二轮再从上一轮最后一个报数的人开始
	 * 依次报1，2，3，1，2，3...报到2，3的人出局。以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
	 * 给定一个int n，代表游戏的人数。请返回最后一个人的编号
	 */

	private int getResult(int n) {
		return ysf(n, 2);
	}

	public int ysf(int n, int m) {
		int tmp = n % m == 0 ? n / m : n / m + 1;
		if (tmp <= m + 1) {
			return (tmp - 1) * m + 1; //终止条件
		}
		int path = ysf(tmp, m + 1); //m+1次时最后一人编号的位置
		return (path - 2) * m + 1;
	}
}
