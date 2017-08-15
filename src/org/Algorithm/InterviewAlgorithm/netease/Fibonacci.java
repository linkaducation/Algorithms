package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/15.
 */
public class Fibonacci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                System.out.println(0);
                return;
            }
            int a = 1, b = 1;
            int min = Integer.MAX_VALUE;
            while (b < n) {
                min = Math.min(Math.abs(b - n), min);
                int temp = a + b;
                a = b;
                b = temp;
            }
            min = Math.min(Math.abs(b - n), min);
            System.out.println(min);
        }
    }
}
