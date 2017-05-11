package org.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ellen on 2017/5/11.
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length < k) {
            return new ArrayList<>();
        }
        Arrays.sort(input);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
}
