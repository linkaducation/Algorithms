package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ellen on 2017/8/4.
 * 编写一个方法，确定某字符串的所有排列组合。
 * 给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，
 * 保证字符串长度小于等于11且字符串中字符均为大写英文字符，排列中的字符串按字典序从大到小排序。(不合并重复字符串)
 * ["ABC"]返回：["CBA","CAB","BCA","BAC","ACB","ABC"]
 */
public class Permutation {

	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		ArrayList<String> res = permutation.getPermutation("abc");
		for (String re : res) {
			System.out.println(re);
		}
	}

	public ArrayList<String> getPermutation(String A) {
		// write code here
		ArrayList<String> list = new ArrayList<>();
		permutation(list, A.toCharArray(), 0);
		Collections.sort(list);
		Collections.reverse(list);
		return list;
	}

	private void permutation(ArrayList<String> list, char[] arr, int k) {
		if (arr.length == k) {
			list.add(new String(arr));
			return;
		}
		for (int i = k; i < arr.length; i++) {
			swap(arr, i, k);
			permutation(list, arr, k + 1);
			swap(arr, i, k);
		}
	}

	private void swap(char[] arr, int i, int k) {
		char temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
	}
}
