package org.Algorithm.Chapter9Algorithm;

import java.util.*;

/**
 * Created by Ellen on 2017/5/30. 给出一个非负整数数组，你最初定位在数组的第一个位置。 数组中的每个元素代表你在那个位置可以跳跃的最大长度。 判断你是否能到达数组的最后一个位置。
 */
public class CanJump {
	public boolean canJump(int[] A) {
		// wirte your code here
		if (A.length <= 0) {
			return false;
		}
		int len = A.length;
		int[] array = new int[len];
		array[0] = A[0];
		if (array[0] <= 0) {
			return false;
		}
		for (int i = 1; i < len; i++) {
			if (array[i - 1] - 1 >= A[i]) {
				array[i] = array[i - 1] - 1;
			} else {
				array[i] = A[i];
			}
			if (i == len - 1) {
				return true;
			}
			if (array[i] <= 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		BitSet bitSet = new BitSet(100);
		Random r = new Random(100);
		for (int i = 0; i < 20; i++) {
			bitSet.set(r.nextInt(100));
		}
		for (int i = 0; i < 100; i++) {
			if (bitSet.get(i)) {
				System.out.print(i + "\t");
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue(10);
		pq.add(112);
		pq.add(10111);
		pq.add(5);
		System.out.println("================");
		Integer[] a = new Integer[3];
		for (Integer integer : pq.toArray(a)) {
			System.out.println(integer);
		}
		System.out.println("================");
		for (int i = 0; i < 3; i++) {
			System.out.println(pq.poll());
		}
		System.out.println("================");
		TreeMap<Integer,Integer> tm = new TreeMap();
		tm.put(300,2);
		tm.put(31,2);
		tm.put(10,20);
		Set set = tm.keySet();
		for (Object o : set) {
			System.out.println(o);
		}
	}
}
