package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/15.
 */
public class Escap {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                sum += arr[i];
            }
            if (sum % n == 0) {
                int avg = sum / n;
                int count = 0, i = 0;
                for (; i < n; i++) {
                    if (arr[i] > avg) {
                        int temp = arr[i] - avg;
                        if (temp % 2 != 0) {
                            break;
                        }
                        count += temp / 2;
                    }
                }
                if (i < n) {
                    System.out.println(-1);
                } else {
                    System.out.println(count);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}
