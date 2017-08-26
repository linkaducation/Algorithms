package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/24.
 */
public class MaxCoins {

    public static void main(String[] args) {
//        MaxCoins maxCoins = new MaxCoins();
//        int i = maxCoins.maxCoins(new int[]{2, 4, 8, 4, 0, 7, 8, 9, 1, 2, 4, 7, 1, 7, 3});
//        System.out.println(i);


    }

    public int maxCoins(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        //初始化
        dp[0] = nums[1];
        dp[len - 1] = nums[len - 2];
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 1; i < len - 1; i++) {
            dp[i] = nums[i - 1] * nums[i + 1];
            if (dp[i] > max) {
                index = i;
                max = dp[i];
            }
        }

        //计算
        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            count += dp[index] * nums[index];
            max = Integer.MIN_VALUE;
            nums[index] = Integer.MIN_VALUE;

            index = 1;
            if (nums[0] != Integer.MIN_VALUE) {
                while (nums[index] == Integer.MIN_VALUE) {
                    index++;
                }
                dp[0] = nums[index];
            }

            index = len - 2;
            if (nums[len - 2] != Integer.MIN_VALUE) {
                while (nums[index] == Integer.MIN_VALUE && index >= 0) {
                    index--;
                }
                dp[len - 1] = nums[index];
            }
            for (int j = 1; j < len - 1; j++) {
                if (nums[j] == Integer.MIN_VALUE) {
                    dp[j] = Integer.MIN_VALUE;
                } else {
                    int pre = j - 1, end = j + 1;
                    while (pre >= 0 && nums[pre] == Integer.MIN_VALUE) {
                        pre--;
                    }
                    while (end < len && nums[end] == Integer.MIN_VALUE) {
                        end++;
                    }
                    if (pre >= 0 && end < len) {
                        dp[j] = nums[pre] * nums[end];
                    } else if (pre > 0) {
                        dp[j] = nums[pre];
                    } else {
                        dp[j] = nums[end];
                    }
                }
                if (dp[j] > max) {
                    max = dp[j];
                    index = j;
                }
            }
            System.out.println(Arrays.toString(dp));
            System.out.println(count);
        }
        int a = -1, b = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                if (a == -1) {
                    a = nums[i];
                } else {
                    b = nums[i];
                }
            }
        }
        count += a * b;
        count += Math.max(a, b);
        return count;
    }
}
