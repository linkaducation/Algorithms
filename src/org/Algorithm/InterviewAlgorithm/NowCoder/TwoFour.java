package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 牛牛在二维坐标系中画了N个点，且都是整点。现在牛牛想画出一个矩形，使得这N个点都在矩形内或者在矩形上。
 * 矩形的边均平行于坐标轴。牛牛希望矩形的面积最小。请你帮助牛牛计算下最小矩形的面积。
 */
public class TwoFour {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			position[] arr = new position[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new position(in.nextInt(), in.nextInt());
			}
			int maxX = Integer.MIN_VALUE, minX = Integer.MAX_VALUE,
					maxY = Integer.MIN_VALUE, minY = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int x = arr[i].x;
				int y = arr[i].y;
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
			}
			System.out.println((maxX - minX) * (maxY - minY));
		}
	}

	static class position{
		int x;
		int y;
		position (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
