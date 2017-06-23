package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)，牛牛现在想把新捕捉的鱼放入鱼缸。
 * 鱼缸内存在着大鱼吃小鱼的定律。经过观察，牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，
 * 鱼A会吃掉鱼B。考虑到这个，牛牛要放入的鱼就需要保证：
 * 1、放进去的鱼是安全的，不会被其他鱼吃掉
 * 2、这条鱼放进去也不能吃掉其他鱼
 * 鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。现在知道新放入鱼的大小范围[minSize,maxSize](考虑鱼的大小都是整数表示),
 * 牛牛想知道有多少种大小的鱼可以放入这个鱼缸。
 */
public class FishSIze {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int minSize = in.nextInt();
			int maxSize = in.nextInt();
			int n = in.nextInt();
			int[] fishes = new int[n];
			for (int i = 0; i < n; i++) {
				fishes[i] = in.nextInt();
			}
			ArrayList<Integer> min = new ArrayList<>();
			ArrayList<Integer> max = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				max.add(fishes[i] / 2);
				if (fishes[i] % 10 > 0) {
					min.add(fishes[i] / 10 + 1);
				} else {
					min.add(fishes[i] / 10);
				}
				min.add(fishes[i] * 2);
				max.add(fishes[i] * 10);
			}
			HashSet<Integer> set = new HashSet<>(min.size() * 2);
			set.add(0);
			for (int i = 0; i < min.size(); i++) {
				for (int j = min.get(i); j <= max.get(i); j++) {
					set.add(j);
				}
			}
			int count = 0;
			for (int i = minSize; i <= maxSize; i++) {
				if (!set.contains(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
