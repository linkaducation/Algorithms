package org.Algorithm.InterviewAlgorithm.MeiTuan;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/24.
 * 给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。
 * 在这组柱状图中找到能组成的最大矩形的面积（如图所示）。 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 */
public class Three {

//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		while (in.hasNextInt()) {
//			int n = in.nextInt();
//			int[] arr = new int[n];
//			for (int i = 0; i < n; i++) {
//				arr[i] = in.nextInt();
//			}
//			ArrayList<Node> list = new ArrayList<>();
//			int max = 0;
//			for (int i = 0; i < n; i++) {
//				if (list.isEmpty() || list.get(list.size() - 1).value <= arr[i]) {
//					list.add(new Node(arr[i], i));
//				}
//				if (list.get(list.size() - 1).value > arr[i]) {
//					for (int j = list.size() - 1; j >= 0; j--) {
//						if (list.get(j).value < arr[i]) {
//							if (j == 0) {
//								max = Math.max(max, arr[i] * (i + 1));
//							} else {
//								max = Math.max(max, arr[i] * (i - j));
//								break;
//							}
//						} else if (j == 0) {
//							int z = 1;
//							int k = list.size() - 1;
//							for (; k >= 0; k--) {
//								if (i - list.get(k).index != z++) {
//									max = Math.max(max, arr[i] * (i - list.get(k).index));
//								}
//							}
//
//						}
//					}
//				}
//			}
//			for (int j = 0; j < list.size(); j++) {
//				max = Math.max(max, list.get(j).value * (list.size() - list.get(j).index));
//			}
//			for (Node node : list) {
//				System.out.print(node.value + "\t");
//			}
//			System.out.println(max);
//		}
//	}
//
//	static class Node {
//		int value;
//		int index;
//
//		Node(int value, int index) {
//			this.value = value;
//			this.index = index;
//		}
//	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			int max = 0;
			for (int i = 0; i < n; i++) {
				int max1 = 0, max2 = 0;
				for (int j = i + 1; j < n; j++) {
					if (arr[i] > arr[j]) {
						max1 = arr[i] * (j - i);
						break;
					}
					if (j == n - 1) {
						max1 = arr[i] * (j - i + 1);
					}
				}
				for (int j = i - 1; j >= 0; j--) {
					if (arr[j] < arr[i]) {
						max2 = arr[i] * (i - j);
						break;
					}
					if (j == 0) {
						max2 = arr[i] * (i + 1);
					}
				}
				if (max1 != 0 && max2 != 0) {
					max1 = max1 - arr[i];
				}
				max = Math.max(max, max1 + max2);
			}
			System.out.println(max);
		}
	}
}
