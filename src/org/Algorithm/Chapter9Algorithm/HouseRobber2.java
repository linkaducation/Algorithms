package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/8/28.
 */
public class HouseRobber2 {

    public static void main(String[] args) {
        HouseRobber2 robber = new HouseRobber2();
        int res = robber.houseRobber2(new int[]{1, 3, 2, 1, 5});
        System.out.println(res);
    }

    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robber(nums, 0, nums.length - 2), robber(nums, 1, nums.length - 1));

    }

    private int robber(int[] nums, int st, int ed) {
        int[] res = new int[2];
        if (st == ed)
            return nums[ed];
        if (st + 1 == ed)
            return Math.max(nums[st], nums[ed]);
        res[st % 2] = nums[st];
        res[(st + 1) % 2] = Math.max(nums[st], nums[st + 1]);

        for (int i = st + 2; i <= ed; i++) {
            res[i % 2] = Math.max(res[(i - 1) % 2], res[(i - 2) % 2] + nums[i]);

        }
        return res[ed % 2];
    }
}
