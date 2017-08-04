package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;

/**
 * Created by Ellen on 2017/8/4.
 * 有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。
 * 给定一个数int k，请返回第k个数。保证k小于等于100。
 */
public class KthNumber {
	public int findKth(int k) {
		// write code here
		int max = 0;
		ArrayList<Integer> list = new ArrayList<>(k);
		list.add(3);
		list.add(5);
		list.add(7);
		for (int i = 3; i < k; i++) {
			int max3 = getMax(list, 3);
			int max5 = getMax(list, 5);
			int max7 = getMax(list, 7);
			list.add(Math.min(Math.min(max3, max5), max7));
		}
		return list.get(k - 1);
	}

	private Integer getMax(ArrayList<Integer> list, int count) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) * count > list.get(list.size() - 1)) {
				return list.get(i) * count;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		KthNumber kthNumber = new KthNumber();
		int kth = kthNumber.findKth(16);
		System.out.println(kth);
	}
}
