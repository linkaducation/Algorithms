package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ellen on 2017/8/10.
 * 现有一些随机生成的数字要将其依次传入，请设计一个高效算法，对于每次传入一个数字后，算出当前所有传入数字的中位数。
 * (若传入了偶数个数字则令中位数为第n/2小的数字，n为已传入数字个数)。
 * 给定一个int数组A，为传入的数字序列，同时给定序列大小n，请返回一个int数组，代表每次传入后的中位数。保证n小于等于1000。
 */
public class Middle {

	public static void main(String[] args) {
		Middle middle = new Middle();
		int[] res = middle.getMiddle(new int[]{1, 2, 3, 4, 5, 6}, 6);
		System.out.println(Arrays.toString(res));
	}

	public int[] getMiddle(int[] A, int n) {
		// write code here
		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		PriorityQueue<Integer> low = new PriorityQueue<>(comp);//大顶堆
		PriorityQueue<Integer> hight = new PriorityQueue<>();//小顶堆


		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			if ((i & 1) == 0) {
				if (hight.isEmpty() || A[i] < hight.peek()) {
					low.add(A[i]);
				} else {
					hight.add(A[i]);
					low.add(hight.poll());
				}
			} else {
				if (A[i] > low.peek()) {
					hight.add(A[i]);
				} else {
					low.add(A[i]);
					hight.add(low.poll());
				}
			}
			res[i] = low.peek();
		}
		return res;
	}

}
