package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.*;

/**
 * Created by Ellen on 2017/8/8.
 * 现在有一个数组，请找出数组中每个元素的后面比它大的最小的元素，若不存在则为-1。
 * 给定一个int数组A及数组的大小n，请返回每个元素所求的值组成的数组。保证A中元素为正整数，且n小于等于1000。
 * <p>
 * 思路：从后往前维护一个小顶堆
 */
public class FindNext2 {

	public static int[] findNext(int[] A, int n) {
		// write code here
		int[] res = new int[n];
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack1.isEmpty() && A[i] >= stack1.peek()) {
				stack2.push(stack1.pop());
			}
			res[i] = stack1.isEmpty() ? -1 : stack1.peek();
			stack1.push(A[i]);
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		}
		return res;
	}

	public static int[] findNext2(int[] A, int n) {
		int[] res = new int[n];
		res[n - 1] = -1;
		PriorityQueue<Integer> queue1 = new PriorityQueue<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = n - 2; i >= 0; i--) {
			while (!queue1.isEmpty() && A[i] > queue1.peek()) {
				list.add(queue1.poll());
			}
			res[i] = queue1.isEmpty() ? -1 : queue1.peek();
			queue1.offer(A[i]);
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				queue1.offer(iterator.next());
				iterator.remove();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] next1 = findNext(new int[]{10981,271060,231334,254597,248942,180532,80446,198879,41046
				,255511,213723,94347,247318,163859,276728,209984,7709,22319,141820,106671,126322,255849,112409}, 23);
		System.out.println(Arrays.toString(next1));
	}
}
