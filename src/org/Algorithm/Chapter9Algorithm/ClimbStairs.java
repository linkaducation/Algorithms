package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/30. 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 */
public class ClimbStairs {
	public int climbStairs(int n) {
		// write your code here
		if (n <= 0) {
			return 1;
		}
		if (n == 1) {
		    return 1;
        }
		int[] array = new int[n];

		// 初始化
		array[0] = 1;
		array[1] = 2;
		for (int i = 2; i < n; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[n - 1];
	}

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        int i = cs.climbStairs(3);
        System.out.println(i);
    }
}
