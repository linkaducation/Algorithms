package org.Algorithm.InterviewAlgorithm.Tencent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/25.
 * geohash编码：geohash常用于将二维的经纬度转换为字符串，分为两步：第一步是经纬度的二进制编码，第二步是base32转码。
 * 此题考察纬度的二进制编码：算法对纬度[-90, 90]通过二分法进行无限逼近（取决于所需精度，本题精度为6）。
 * 注意，本题进行二分法逼近过程中只采用向下取整来进行二分，针对二分中间值属于右区间。算法举例如下：
 * 针对纬度为80进行二进制编码过程：
 * 1) 区间[-90, 90]进行二分为[-90, 0),[0, 90]，成为左右区间，可以确定80为右区间，标记为1；
 * 2) 针对上一步的右区间[0, 90]进行二分为[0, 45),[45, 90]，可以确定80是右区间，标记为1；
 * 3) 针对[45, 90]进行二分为[45, 67),[67,90],可以确定80为右区间，标记为1；
 * 4) 针对[67,90]进行二分为[67, 78),[78,90]，可以确定80为右区间，标记为1；
 * 5) 针对[78, 90]进行二分为[78, 84),[84, 90]，可以确定80为左区间，标记为0；
 * 6) 针对[78, 84)进行二分为[78, 81), [81, 84)，可以确定80为左区间，标记为0；
 * 输入80，输出111100
 */
public class Fourth {

	private static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		while (in.hasNextInt()) {
//			int n = in.nextInt();
//			int[] arr = new int[181];
//			for (int i = 0; i < 181; i++) {
//				arr[i] = i - 90;
//			}
//			getQueue(arr, n, 0, 180);
//			if (n == -66) {
//				list.set(list.size() - 1, 0);
//			}
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(list.get(i));
//			}
//			list.clear();
//		}
		while (in.hasNextInt()) {
			int n = in.nextInt();
			String s = "";
			int i = -90;
			int j = 90;
			while (j - i >= 5) {
				if (n >= Math.floor((i + j) / 2)) {
					s += "1";
					i = (int) Math.floor((i + j) / 2);
				} else {
					s += "0";
					j = (int) Math.floor((i + j) / 2);
				}
			}
			System.out.println(s);
		}
	}

//	private static void getQueue(int[] arr, int n, int start, int end) {
//		if (end - start < 5) {
//			if ((end != 90 || start != -90) && end - start == 5) {
//			} else {
//				return;
//			}
//		}
//		int mid = start + (end - start) / 2;
//		if (arr[mid] <= n) {
//			list.add(1);
//			getQueue(arr, n, mid, end);
//		} else {
//			list.add(0);
//			getQueue(arr, n, start, mid);
//		}
//	}
}
