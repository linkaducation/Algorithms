package org.Algorithm.BestSolution;

import java.util.HashMap;

/**
 * Created by Ellen on 2017/9/1.
 */
public class MaxLength {

    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{1, 2, 3, 4, 5}, 5));
    }

    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);// important
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            } else {
                map.put(sum, i);
            }
        }
        return len;
    }
}
