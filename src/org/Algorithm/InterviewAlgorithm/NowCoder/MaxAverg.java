package org.Algorithm.InterviewAlgorithm.NowCoder;

		import java.util.Arrays;
		import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/22.
 * 如果方案为:
 * team1:{1,2,5}, team2:{5,5,8}, 这时候水平值总和为7.
 * 而如果方案为:
 * team1:{2,5,8}, team2:{1,5,5}, 这时候水平值总和为10.
 * 没有比总和为10更大的方案,所以输出10.
 */
public class MaxAverg {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {


			int n = in.nextInt();
			int[] arr = new int[n * 3];
			for (int i = 0; i < n * 3; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			long count = 0;
			int j = 0;
			for (int i = arr.length - 1; j < n; j++) {
				count += arr[i - 1];
				i = i - 2;
			}
			System.out.println(count);
		}
	}
}
