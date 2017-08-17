package org.Algorithm.InterviewAlgorithm.HaoWeilai;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class MoreThanHalf {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.nextLine();
            String[] arr = string.split(" ");
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }
            }
            int len = arr.length / 2;
            for (String s : map.keySet()) {
                if (map.get(s) >= len) {
                    System.out.println(s);
                    break;
                }
            }
        }
    }
}
