package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/16.
 */
public class GentalNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int r = in.nextInt();
            int x = -(int) Math.sqrt(r);
            int count = 0;
            while (x <= (int) Math.sqrt(r)) {
                int sqrt = (int)Math.sqrt(r - x * x);
                if (sqrt * sqrt + x * x == r) {
                    count += 2;
                }
                x++;
            }
            if ((int) Math.sqrt(r) * (int) Math.sqrt(r) == r) {
                count -= 2;
            }
            System.out.println(count);
        }
    }

}
