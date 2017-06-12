package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/6/12. 给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？
 */
public class BackPackII {
	public int backPackII(int m, int[] A, int V[]) {
		// write your code here
		if (A == null || V == null || A.length <= 0 || V.length <= 0) {
			return 0;
		}
		int[] value = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			value[i] = A[i] * V[i];
		}
		boolean[][] f = new boolean[A.length + 1][m + 1];
		f[0][0] = true;
		for (int i = 1; i <= A.length; i++) {
			for (int j = 0; j <= m; j++) {
				f[i][j] = f[i - 1][j];
				if (j >= value[i - 1] && f[i - 1][j - value[i - 1]]) {
					f[i][j] = true;
				}
			}
		}
		for (int i = A.length; i >= 0; i--) {
			for (int j = m; j >= 0; j--) {
				if (f[i][j]) {
					return j;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		BackPackII backPackII = new BackPackII();
        int i = backPackII.backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4});
        System.out.println(i);
    }
}
