package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 */
public class SycleWord {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			String[] arr = new String[n];
			HashSet<String> set = new HashSet<>();
			int cout = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = in.next();
				if (!set.contains(arr[i])) {
					cout++;
					for (int j = 0; j < arr[i].length() - 1; j++) {
						char[] array = arr[i].toCharArray();
						for (int k = 0; k < array.length; k++) {
							StringBuilder sb = new StringBuilder();
							for (int l = 0; l < array.length && l != k; l++) {

							}
						}
					}
				}
			}
			System.out.println(cout);

		}
	}
}
