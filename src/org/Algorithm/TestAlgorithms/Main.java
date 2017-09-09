package org.Algorithm.TestAlgorithms;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            HashMap<String, Integer> map = new HashMap<>();
            String str = in.next();
            System.out.println(dfs(str, map));
        }
    }

    public static int dfs(String str, HashMap<String, Integer> map) {
        if (str.length() == 0) {
            return 1;
        }
        int tem = 0;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        int left = 1;
        int right = 0;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') left++;
            else {
                right++;
                if (left >= right) {
                    String next = str.substring(1, i) + str.substring(i + 1);
                    int temp = dfs(next, map);
                    tem += temp;
                }
            }
        }
        map.put(str, tem);
        return tem;
    }


}

