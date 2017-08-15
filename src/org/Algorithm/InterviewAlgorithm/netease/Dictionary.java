package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/15.
 */
public class Dictionary {

    static class treeNode{
        treeNode(char value) {
            this.value = value;
        }
        char value;
        treeNode[] next = new treeNode[26];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String key = in.next();
            boolean flag = true;
            for (int i = 1; i < key.length(); i++) {
                if (key.charAt(i) == key.charAt(i - 1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Likes");
            } else {
                System.out.println("Dislikes");
            }
        }
    }


}


