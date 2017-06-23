package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 牛牛正在挑战一款名为01翻转的游戏。游戏初始有A个0,B个1，牛牛的目标就是把所有的值都变为1，
 * 每次操作牛牛可以任意选择恰好K个数字，并将这K个数字的值进行翻转(0变为1，1变为0)。
 * 牛牛如果使用最少的操作次数完成这个游戏就可以获得奖品，牛牛想知道最少的操作次数是多少？
 * 例如:A = 4 B = 0 K = 3
 * 0000 -> 1110 -> 1001 -> 0100 -> 1111
 * 需要的最少操作次数为4
 */
public class ChangeCardTo1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			int ans = BFS(a, b, k);
			System.out.print(ans);
		}
	}

	public static int BFS(int a, int b, int k) {
		int n = a + b;
		boolean[] vis = new boolean[n + 1];
		Arrays.fill(vis, false);
		Queue<Step> q = new LinkedList<>();
		Step start = new Step(a, b, 0);
		q.offer(start);
		vis[a] = true;
		while (!q.isEmpty()) {
			Step s = q.poll();
			if (s.a == 0) {
				return s.step;
			}
			for (int i = 1; i <= Math.min(s.a, k); i++) {
				if (s.b < k - i) {
					continue;
				}
				int next = s.a - i + (k - i);
				if (next == 0) {
					return s.step + 1;
				}
				if (!vis[next]) {
					vis[next] = true;
					q.offer(new Step(next, n - next, s.step + 1));
				}
			}
		}
		return -1;
	}
}
class Step {
	public int a;
	public int b;
	public int step;

	public Step(int a, int b, int step) {
		this.a = a;
		this.b = b;
		this.step = step;
	}
}


