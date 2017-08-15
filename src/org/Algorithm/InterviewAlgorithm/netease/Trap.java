package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/15.
 */
public class Trap {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y[i] = in.nextInt();
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, Math.abs(x[i] - 1) + Math.abs(y[i] - 1));
            }
            System.out.println(min);
        }
    }
}
