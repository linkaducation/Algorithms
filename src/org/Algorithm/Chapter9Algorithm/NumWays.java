package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/30. 我们有一个栅栏，它有n个柱子，现在要给柱子染色，有k种颜色可以染。 必须保证不能有连续三个柱子颜色相同，求有多少种染色方案。
 */
public class NumWays {
	public int numWays(int n, int k) {
		// Write your code here
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        if (n == 2)
            return k*k;
        int pre = k;
        int now = k*k;
        for (int i = 3; i <= n; i++)
        {
            int tmp = now;
            now = (pre+now) * (k-1);
            pre = tmp;
        }
        return now;
    }

}
