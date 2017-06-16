package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/6/16.
 * 给你一个没有排序的数组，请将原数组就地重新排列满足如下性质
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (flag) {
                    if (nums[i] > nums[j]) {
                        int k = nums[j];
                        nums[j] = nums[i];
                        nums[i] = k;
                    }
                } else {
                    if (nums[i] < nums[j]) {
                        int k = nums[j];
                        nums[j] = nums[i];
                        nums[i] = k;
                    }
                }
            }
            if (i % 2 == 0) {
                flag = false;
            } else {
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        WiggleSort ws = new WiggleSort();
        int[] arr = new int[]{3, 5, 2, 1, 6, 4};
        ws.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
