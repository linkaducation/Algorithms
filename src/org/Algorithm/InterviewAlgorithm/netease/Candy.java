package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/16.
 */
public class Candy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int ab1 = in.nextInt();
            int bc1 = in.nextInt();
            int ab2 = in.nextInt();
            int bc2 = in.nextInt();
            if ((ab1 + ab2)% 2 == 1 || (bc1 + bc2) % 2 == 1) {
                System.out.println("No");
                return;
            }
            int a = (ab1 + ab2) / 2;
            int b = ab2 - a;
            int b2 = (bc1 + bc2) / 2;
            int c = bc2 - b2;
            if (b == b2 && b >= 0 && a >= 0 && c >= 0) {
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println("No");
            }
        }
    }
}
