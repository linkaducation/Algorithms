package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/7.
 * 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。
 * 给定一个string数组article和数组大小n及一个待统计单词word，请返回该单词在文章中的出现频数。保证文章的词数小于等于1000。
 */
public class GetFrequency {
	public int getFrequency(String[] article, int n, String word) {
		// write code here
		int count = 0;
		for (String s : article) {
			if (word.equals(s)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		GetFrequency frequency = new GetFrequency();
		int i = frequency.getFrequency(new String[]{"a", "b", "a", "ab", "abc"}, 5, "a");
		System.out.println(i);
	}
}
