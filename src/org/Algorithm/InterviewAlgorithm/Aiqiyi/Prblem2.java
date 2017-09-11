package org.Algorithm.InterviewAlgorithm.Aiqiyi;

        import java.util.Scanner;

/**
 * Created by Ellen on 2017/9/10.
 */
public class Prblem2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.next();
        int count = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < target.length(); i++) {
            count = target.charAt(i) == '(' ? count + 1 : count - 1;
            res = Math.max(res, count);
        }
        System.out.println(res);
    }
}