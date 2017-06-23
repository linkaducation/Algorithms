package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 */
public class SycleWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //第一行为单词个数n(1 ≤ n ≤ 50)
		ArrayList<String> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			String s = sc.next(); //输入并存储每行的单词。此处必须调用next（）方法，不能是nextLine（）方法
			if (!list.contains(s)) {
				count++;
				list.add(s);
				for (int j = 0; j < s.length() - 1; j++) {
					char last = s.charAt(s.length() - 1);
					s = s.substring(0, s.length() - 1);
					s = last + s;
					list.add(s);
					//以下注释是另一种方法，把可能的循环单词加入list，
					//思路：把要测试的单词后再重复下这个单词，如：picture ，变成 picturepicture
					//感谢得闲半生的idea
//                    StringBuffer string = new StringBuffer();
//                    string.append(s);
//                    string.append(s);
//                    String another = string.substring(j, s.length() + j);
//                    list.add(another);
				}
			}
		}
		sc.close();
		System.out.println(count);
	}
}
