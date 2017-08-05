package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/5.
 */
public class Permutate {
	private static int total = 0;

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void perm(char[] arr, int str, int len) {
		if (str == len - 1) {
			System.out.println(Arrays.toString(arr));
			total++;
		} else {
			for (int i = str; i < len; i++) {
				swap(arr, str, i);
				perm(arr, str + 1, len);
				swap(arr, str, i);
			}
		}
	}

	public static void main(String[] args) {
		String str = "abc";
		char[] chars = str.toCharArray();
		perm(chars, 0, chars.length);
		System.out.println(total);
	}
}
