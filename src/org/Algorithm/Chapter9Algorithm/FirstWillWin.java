package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/8/27.
 * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
 * 请判定 第一个玩家 是输还是赢？
 * <p>
 * 方法1：记忆搜索法 方程Fn[i]表示第i个硬币是被谁拿走了，i==2为第一个人，i=1为第二个人
 * 方法2：动态规划 dp[i]表示拿走该硬币的是否是第一个拿的人
 */
public class FirstWillWin {
    public boolean firstWillWin(int n) {
        // write your code here
        int[] dp = new int[n];
        return search(dp, n);
    }

    private boolean search(int[] dp, int n) {
        if (dp[n] != 0) {
            return dp[n] != 1;
        }
        if (n <= 0) {
            dp[n] = 1;
        } else if (n == 1) {
            dp[n] = 2;
        } else if (n == 2) {
            dp[n] = 2;
        } else if (n == 3) {
            dp[n] = 1;
        } else {
            if ((search(dp, n - 2) && search(dp, n - 3)) ||
                    (search(dp, n - 3) && search(dp, n - 1))) {
                dp[n] = 2;
            } else {
                dp[n] = 1;
            }
        }

        return dp[n] == 2;
    }


    public boolean firstWin(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        for (int i = 3; i <= n; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 2];
        }
        return dp[n];
    }
}
