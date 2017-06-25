package org.Algorithm.InterviewAlgorithm.Tencent;

import java.util.Scanner;

	/**
	 * Created by Ellen on 2017/6/25.
	 * 假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，
	 * 如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …,
	 * b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，
	 * 以此类推。 编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
	 */
	public class First {

//		public static void main(String[] args) {
//			Scanner in = new Scanner(System.in);
//			while (in.hasNext()) {
//				String key = in.next();
//				int value = 0;
//				if (key.length() <= 3) {
//					value = 16276 * (key.charAt(0) - 'a') + key.length() - 1;
//					System.out.println(value);
//				} else {
//					value = 16276 * (key.charAt(0) - 'a') + 3 + 651 * (key.charAt(1) - 'a')
//							+ 26 * (key.charAt(2) - 'a') + 1 * (key.charAt(3) - 'a');
//					System.out.println(value);
//				}
//			}
//		}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {

			String s = in.next();
			char arr[] = s.toCharArray();
			int index = 0;
			if (s.length() == 1) {
				int a = arr[0];
				index = (a - 'a') * (16276);
			} else if (s.length() == 2) {
				int a = arr[0];
				int b = arr[1];
				index = (a - 'a') * (16276) + (b - 'a') * (651) + 1;
			} else if (s.length() == 3) {
				int a = arr[0];
				int b = arr[1];
				int c = arr[2];
				index = (a - 'a') * (16276) + (b - 'a') * (651) + (c - 'a') * (26) + 2;
			} else {
				int a = arr[0];
				int b = arr[1];
				int c = arr[2];
				int d = arr[3];
				index = (a - 'a') * (16276) + (b - 'a') * (651) + (c - 'a') * (26) + (d - 'a') + 3;
			}
			System.out.println(index);
		}
	}
}
