package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/6/2. 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i] 如果有4个物品[2, 3, 5, 7] 如果背包的大小为11，可以选择[2,
 * 3, 5]装入背包，最多可以装满10的空间。 如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。 函数需要返回最多能装满的空间大小。
 */
public class BackPack {
	public int backPack(int m, int[] A) {
		// write your code here
        if (m <= 0 || A.length <= 0) {
            return 0;
        }
        int len = A.length;
        int[] result = new int[len];//存放扫描结果
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < ; j++) {

            }
        }
    }
}
