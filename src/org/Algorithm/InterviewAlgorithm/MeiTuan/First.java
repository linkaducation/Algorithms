package org.Algorithm.InterviewAlgorithm.MeiTuan;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/24.
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，
 * 点数为2时可以走两步，点数为n时可以走n步。求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，
 * 总共有多少种投骰子的方法。
 */
public class First {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			if (n <= 6) {
				System.out.println(1 << --n);
			}
		}
	}
}
