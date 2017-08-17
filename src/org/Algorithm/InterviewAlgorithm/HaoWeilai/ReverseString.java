package org.Algorithm.InterviewAlgorithm.HaoWeilai;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class ReverseString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.nextLine();
            string = reverse(string);//I like  beijing.
            int pre = 0, pos = 0;
            StringBuilder sb = new StringBuilder();
            while (pre < string.length()) {
                if (string.charAt(pre) == ' ') {
                    if (pre != pos) {
                        sb.append(reverse(string.substring(pos, pre)) + " ");
                        pos = pre;
                    } else {
                        pre++;
                        pos++;
                    }
                } else {
                    pre++;
                }
            }
            if (pre != pos) {
                sb.append(reverse(string.substring(pos, pre)));
            }
            System.out.println(sb.toString());
        }
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
