package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ellen on 2017/6/26.
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，
 * 但不得将元素复制到别的数据结构中。给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，
 * 请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素
 */
public class TwoStacksSort {
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		// write code here

		ArrayList<Integer> result = new ArrayList<>(numbers.length);

		//初始化原始栈
		Stack<Integer> stack = new Stack<>();
		int index = numbers.length - 1;
		for (int i = index; i >= 0; i--) {
			stack.push(numbers[i]);
		}

		Stack<Integer> resultStack = new Stack<>();//额外的栈
		while (!stack.empty()) {
			if (resultStack.empty()) {
				resultStack.push(stack.pop());
			} else {
				int a = stack.pop();
				int b = resultStack.pop();
				if (a < b) {
					stack.push(b);
					while (!resultStack.empty() && a < (b = resultStack.pop())) {
						stack.push(b);
					}
				}
				if (a >= b) {
					resultStack.push(b);
				}
				resultStack.push(a);
			}
		}

		//返回ArrayList结果
		while (!resultStack.empty()) {
			result.add(resultStack.pop());
		}
		return result;
	}

	public static void main(String[] args) {
		TwoStacksSort twoStacksSort = new TwoStacksSort();
		ArrayList<Integer> integers = twoStacksSort.twoStacksSort(new int[]{54695, 46580, 6418, 52304, 5595, 5149, 51943, 11454, 23596, 6444, 61037, 94146, 50220,
				98642, 97292, 57898, 11745, 7286, 31224, 5160, 41550, 25277, 59350, 53353, 68663, 9642, 30406, 5396, 3222, 67194, 7124, 54247, 15077, 97688, 36939, 62888, 80307,
				65467, 6882, 97071, 39652, 38268, 88226, 89088, 92198, 39003, 9858, 73803, 83078, 24648, 49891, 34551, 57649, 24443, 30685, 68740, 55407, 53155, 87465, 89282,
				41856, 96218, 37292, 24551, 67663, 31715, 46363, 25573, 61921, 56333, 69576, 55919, 19818, 26409, 21590, 70392, 67648, 36909, 89175, 74443, 41856, 11755, 24788,
				25975, 25116, 57360, 80998, 62093, 40691, 91189, 29337, 68914, 57653, 64272, 53653, 5975, 27967, 59600, 25803, 13937, 93725, 26457, 16603, 18360, 79926, 63243,
				94958, 45131});
		for (int i = 0; i < integers.size(); i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(integers.get(i) + "\t");
		}
	}
}
