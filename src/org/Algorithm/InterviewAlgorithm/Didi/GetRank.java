package org.Algorithm.InterviewAlgorithm.Didi;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class GetRank {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = 0;
            for (int i = n; i >= 5; i--) {
                int temp = i;
                while (temp % 5 == 0) {
                    sum++;
                    temp /= 5;
                }
            }
            System.out.println(sum);
        }
    }
}
