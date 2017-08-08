package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/8.
 * 有一篇文章内含多个单词，现给定两个单词，请设计一个高效算法，找出文中这两个单词的最短距离(即最少相隔的单词数,也就是两个单词在文章中位置的差的绝对值)。
 * 给定一个string数组article，代表所给文章，同时给定文章的单词数n和待查找的两个单词x和y。请返回两个单词的最短距离。
 * 保证两个单词均在文中出现且不相同，同时保证文章单词数小于等于1000。
 */
public class GetDistance {

	public static int getDistance(String[] article, int n, String x, String y) {
		// write code here
		int index1 = -1, index2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (article[i].equals(x)) {
				index1 = i;
			} else if (article[i].equals(y)) {
				index2 = i;
			}
			if (index1 != -1 && index2 != -1) {
				min = Math.min(min, Math.abs(index1 - index2));
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String[] article = new String[]{"jsem", "mpxmm", "hr", "hr", "kkyrkbp", "x", "mpxmm", "oib", "zuuzcyn", "jsem", "risa", "g"
				, "lmzjyh", "mpxmm", "zuuzcyn", "kkyrkbp", "tmqxc", "niihkms", "x", "kkyrkbp"
				, "lmzjyh", "tmqxc", "oib", "jsem", "mpxmm", "mpxmm", "kkyrkbp", "esceohm", "hr", "g", "niihkms", "jdjmlf", "jsem", "hr", "esceohm", "lmzjyh", "zuuzcyn", "jsem", "g", "jsem"
				, "infs", "tmqxc", "kkyrkbp", "hr", "lmzjyh", "jdjmlf", "tmqxc", "tmqxc", "zuuzcyn", "lmzjyh", "x", "tmqxc"};
		int distance = getDistance(article, 52, "lmzjyh", "mpxmm");
		System.out.println(distance);
	}
}
