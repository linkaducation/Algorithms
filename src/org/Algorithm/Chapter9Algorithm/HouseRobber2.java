package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/8/28.
 */
public class HouseRobber2 {

    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        boolean[] hasFirst = new boolean[len];
        hasFirst[0] = true;
        hasFirst[2] = true;
        for (int i = 3; i < len; i++) {
            if (dp[i - 2] > dp[i - 3]) {
                dp[i] = dp[i - 2] + nums[i];
                if (hasFirst[i - 2]) {
                    hasFirst[i] = true;
                }
            } else if (dp[i - 2] > dp[i - 3]){
                dp[i] = dp[i - 3] + nums[i];
                if (hasFirst[i - 3]) {
                    hasFirst[i] = true;
                }
            } else {
                if (hasFirst[i - 3]) {
                    if (!hasFirst[i - 2]) {
                        dp[i] = dp[i - 2] + nums[i];
                    }
                } else {
//                    dp[i] =
                }
            }
        }
        int max = 0;
        if ((len & 1) == 1) {
            max = Math.max(dp[len - 1] - nums[len - 1], dp[len - 1] - nums[0]);
        }
        max = Math.max(max, dp[len - 2]);
        return max;
    }

}
