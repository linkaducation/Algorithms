package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/4.
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。为
 * 了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 */
public class GoUpstairs {
	public int countWays(int n) {
		// write code here
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		for (int i = 3; i < n; i++) {
			arr[i] = ((arr[i - 1] + arr[i - 2]) % 1000000007 + arr[i - 3]) % 1000000007;
		}
		return arr[n - 1];
	}

	public static void main(String[] args) {
		GoUpstairs goUpstairs = new GoUpstairs();
		int i = goUpstairs.countWays(36196);
		System.out.println(i);
	}
}
