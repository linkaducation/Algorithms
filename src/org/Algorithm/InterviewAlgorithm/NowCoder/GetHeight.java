package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/7.
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。同时我们应该让下面的人比上面的人更高一点。
 * 已知参加游戏的每个人的身高，请编写代码计算通过选择参与游戏的人，我们多能叠多少个人。注意这里的人都是先后到的，
 * 意味着参加游戏的人的先后顺序与原序列中的顺序应该一致。
 * 给定一个int数组men，代表依次来的每个人的身高。同时给定总人数n，请返回最多能叠的人数。保证n小于等于500。
 * <p>
 * 最长递增子序列
 */
public class GetHeight {

	public static int getHeight(int[] men, int n) {
		// write code here
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (men[i] > men[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		return max;
	}


	/**
	 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。为了使叠成的罗汉更稳固，我们应该让上面的人比下面的人更轻一点。
	 * 现在一个马戏团要表演这个节目，为了视觉效果，我们还要求下面的人的身高比上面的人高。请编写一个算法，计算最多能叠多少人，
	 * 注意这里所有演员都同时出现。
	 * 给定一个二维int的数组actors，每个元素有两个值，分别代表一个演员的身高和体重。同时给定演员总数n，请返回最多能叠的人数。
	 * 保证总人数小于等于500。
	 *
	 * @param
	 */
	public static int getHeight(int[][] actors, int n) {
		// write code here
		//排序 体重由大到小
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (actors[i][1] < actors[j][1]) {
					swap(actors, i, j);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(actors[i][0] + " " + actors[i][1]);
		}
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (actors[i][1] < actors[j][1] && actors[i][0] < actors[j][0]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		return res;
	}

	private static void swap(int[][] arr, int i, int j) {
		int temp = arr[i][1];
		int temp2 = arr[i][0];
		arr[i][1] = arr[j][1];
		arr[i][0] = arr[j][0];
		arr[j][1] = temp;
		arr[j][0] = temp2;
	}

	public static void main(String[] args) {
		int[][] actor = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		int height = getHeight(actor, 4);
		System.out.println(height);
	}

}
