package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.HashMap;

/**
 * Created by Ellen on 2017/8/7.
 * 我们现在有四个槽，每个槽放一个球，颜色可能是红色(R)、黄色(Y)、绿色(G)或蓝色(B)。
 * 例如，可能的情况为RGGB(槽1为红色，槽2、3为绿色，槽4为蓝色)，作为玩家，你需要试图猜出颜色的组合。
 * 比如，你可能猜YRGB。要是你猜对了某个槽的颜色，则算一次“猜中”。要是只是猜对了颜色但槽位猜错了，
 * 则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * 给定两个string A和guess。分别表示颜色组合，和一个猜测。请返回一个int数组，第一个元素为猜中的次数，第二个元素为伪猜中的次数。
 */
public class CalcResult {
	public static int[] calcResult(String A, String guess) {
		// write code here
		int right = 0, unRight = 0;
		HashMap<Character, Integer> map = new HashMap<>(A.length());
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == guess.charAt(i)) {
				right++;
			}
			if (map.containsKey(A.charAt(i))) {
				map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
			} else {
				map.put(A.charAt(i), 1);
			}
		}
		for (int i = 0; i < guess.length(); i++) {
			Integer k = map.get(guess.charAt(i));

			if (k != null && k > 0) {
				unRight++;
				k--;
				map.put(guess.charAt(i), k);
			}
		}
		unRight -= right;
		if (unRight < 0) {
			unRight = 0;
		}
		return new int[]{right, unRight};
	}

	public static void main(String[] args) {
		int[] ints = calcResult("YRGR", "GRRR");
		System.out.println(ints[0] + " : " + ints[1]);
	}
}
