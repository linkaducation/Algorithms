package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/8/28.
 * 给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。
 * 你总共三种操作方法：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 思路：寻找最长公共子串，其它的做变化
 * 最长公共子串方法：
 * Fn[i]表示子串第i个字符位置时和父串匹配的最长大小
 * 初始化：Fn[0] = 0;
 * 状态转移方程：
 * if (subString.charAt(i) == )
 */
public class MinDistance {

    public static void main(String[] args) {
        int res = minDistance("sea", "ate");
        System.out.println(res);
    }

    public static int minDistance(String word1, String word2) {
        // write your code here
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i=0; i< m+1; i++){
            dp[0][i] = i;
        }
        for(int i=0; i<n+1; i++){
            dp[i][0] = i;
        }

        for(int i = 1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[n][m];
    }
}
