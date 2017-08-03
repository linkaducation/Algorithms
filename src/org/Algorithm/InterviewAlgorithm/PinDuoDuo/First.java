package org.Algorithm.InterviewAlgorithm.PinDuoDuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/7/31.
 */
public class First {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int hlen = in.nextInt();
			int[] h = new int[hlen];//小朋友
			for (int i = 0; i < hlen; i++) {
				h[i] = in.nextInt();
			}
			int mlen = in.nextInt();//巧克力重量
			int[] m = new int[mlen];
			for (int i = 0; i < mlen; i++) {
				m[i] = in.nextInt();
			}
			Arrays.sort(m);
			boolean[] isHave = new boolean[hlen];
			int count = 0;
			for (int i = 0; i < mlen; i++) {
				for (int j = 0; j < hlen; j++) {
					if (!isHave[j] && m[i] > h[j]) {
						count++;
						isHave[j] = true;
						break;
					}
				}
			}
			System.out.println(count);
		}
	}

}
