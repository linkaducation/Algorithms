package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/16.
 */
public class MaxOddNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long n = in.nextInt();
            long sum = 0;
            for (long i = n; i > 0; i = i / 2) {
                long temp = (i + 1) / 2;
                sum += temp * temp;
            }
            System.out.println(sum);
        }
    }

}
