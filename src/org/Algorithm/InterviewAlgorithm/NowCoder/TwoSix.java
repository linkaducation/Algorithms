package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 * 牛牛有N个字符串，他想将这些字符串分类，他认为两个字符串A和B属于同一类需要满足以下条件：
 * A中交换任意位置的两个字符，最终可以得到B，交换的次数不限。比如：abc与bca就是同一类字符串。
 * 现在牛牛想知道这N个字符串可以分成几类。
 */
public class TwoSix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			HashSet<String> set = new HashSet<String>();
			while (n != 0) {
				char[] array = in.next().toCharArray();
				Arrays.sort(array);
				set.add(String.valueOf(array));
				n--;
			}
			System.out.println(set.size());
		}

	}
}
