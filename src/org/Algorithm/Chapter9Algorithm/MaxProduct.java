package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/8/29.
 */
public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int res = maxProduct.maxProduct(new int[]{-1, 100});
        System.out.println(res);
    }

    public int maxProduct(int[] nums) {
        // write your code here
        int count = 0, st = 0, index = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[i] < 0) {
                    count++;
                }
                if (count % 2 == 0) {
                    index = i;
                }
            } else {
                res = Math.max(res, getTimes(nums, st, index));
                st = i + 1;
                index = i + 1;
                count = 0;
            }
        }
        res = Math.max(res, getTimes(nums, st, index));
        return res;
    }

    private int getTimes(int[] nums, int st, int ed) {
        int res = 1;
        for (int i = st; i <= ed; i++) {
            res *= nums[i];
        }
        return res;
    }
}
