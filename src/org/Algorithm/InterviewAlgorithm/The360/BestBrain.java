package org.Algorithm.InterviewAlgorithm.The360;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class BestBrain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.nextLine();
            String a = in.nextLine();
            String b = in.nextLine();
            if (a.equals(b)) {
                flag temp = getNode(string, a, "");
                flag temp1 = getNode1(string, a, "");
                if (temp != null) {
//                    if (temp1 != null && temp.pos) {
//                    }
                }
            }
            ArrayList<String> list = new ArrayList<>();
            flag flag = getNode(string, a, "a");
            flag flag1 = getNode(string, b, "b");
            if (flag != null && flag1 != null) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb1 = new StringBuilder();
                if (flag.pos < flag1.pos) {
                    sb.append(string);
                    sb.reverse();
                    sb1.append(a);
                    sb1.reverse();
                    flag flag2 = getNode(sb.toString(), sb1.toString(), "a");
                    if (flag2 != null) {
                        if (flag2.pos > flag1.pos) {
                            System.out.println("both ");
                        }
                    } else {
                        System.out.println("forward ");
                    }
                } else {

                }
            }
        }
    }

    private static boolean reverse(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static flag getNode1(String string, String sub, String who) {
        for (int i = string.length() - 1; i >= sub.length(); i--) {
            int j = 0;
            for (; j < sub.length(); j++) {
                if (string.charAt(i - j) != sub.charAt(j)) {
                    break;
                }
            }
            if (j == sub.length() - 1) {
                return new flag(i, who);
            }
        }
        return null;
    }

    private static flag getNode(String string, String sub, String who) {
        boolean flag = false;
        for (int i = 0; i < string.length() - sub.length(); i++) {
            int j = 0;
            for (; j < sub.length(); j++) {
                if (string.charAt(i + j) != sub.charAt(j)) {
                    if (flag) {

                    }
                }
            }
            if (j == sub.length() - 1) {
                return new flag(i, who);
            }
        }
        return null;
    }

    static class flag {
        int pos;
        String who;

        flag(int pos, String who) {
            this.pos = pos;
            this.who = who;
        }
    }
}
