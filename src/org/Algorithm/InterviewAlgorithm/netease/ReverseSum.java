package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/16.
 */
public class ReverseSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int x = in.nextInt();
            int y = in.nextInt();
            int res = reverse(reverse(x) + reverse(y));
            System.out.println(res);
        }
    }

    private static int reverse(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 10);
            n = n / 10;
        }
        return Integer.valueOf(sb.toString());
    }
}
