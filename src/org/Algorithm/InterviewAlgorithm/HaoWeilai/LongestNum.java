package org.Algorithm.InterviewAlgorithm.HaoWeilai;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class LongestNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.nextLine();
            int pre = 0, pos = pre;
            String res = "";
            int max = 0;//12ndnv342vfk
            while (pre < string.length()) {
                if (string.charAt(pre) >= '0' && string.charAt(pre) <= '9') {
                    pre++;
                } else {
                    if (pre != pos) {
                        if (pre - pos > max) {
                            res = string.substring(pos, pre);
                            max = pre - pos;
                        }
                        pos = pre;
                    } else {
                        pre++;
                        pos++;
                    }
                }
            }
            if (string.charAt(pre - 1) >= '0' && string.charAt(pre - 1) <= '9' && pre != pos) {
                if (pre - pos > max) {
                    res = string.substring(pos, pre);
                }
            }
            System.out.println(res);
        }
    }

}
