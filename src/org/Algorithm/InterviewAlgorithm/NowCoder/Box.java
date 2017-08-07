package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/7.
 * 有一堆箱子，每个箱子宽为wi，长为di，高为hi，现在需要将箱子都堆起来，而且为了使堆起来的箱子不到，
 * 上面的箱子的宽度和长度必须小于下面的箱子。请实现一个方法，求出能堆出的最高的高度，这里的高度即堆起来的所有箱子的高度之和。
 * 给定三个int数组w,l,h，分别表示每个箱子宽、长和高，同时给定箱子的数目n。请返回能堆成的最高的高度。保证n小于等于500。
 */
public class Box {

	public int getHeight(int[] w, int[] l, int[] h, int n) {
		// write code here
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (w[i] < w[j]) {
					swap(w, i, j);
					swap(l, i, j);
					swap(h, i, j);
				}
			}
		}

		int[] dp = new int[n];
		dp[0] = h[0];
		for (int i = 1; i < n; i++) {
			dp[i] = h[i];
			for (int j = i - 1; j >= 0; j--) {
				if (l[i] < l[j] && w[i] < w[j]) {
					dp[i] = Math.max(dp[i], dp[j] + h[i]);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(dp[i], max);
		}
		return max;
	}


	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
