package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/5/11.
 * 1.采用阵地攻守的思想： 第一个数字作为第一个士兵，守阵地；count = 1；
 * 遇到相同元素，count++; 遇到不相同元素，即为敌人，同归于尽,count--；
 * 当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，
 * 到最后还留在阵地上的士兵，有可能是主元素。 再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
 * <p>
 * 2.采用用户“分形叶”思路（注意到目标数 超过数组长度的一半，
 * 对数组同时去掉两个不同的数字，到最后剩下的一个数就是该数字。
 * 如果剩下两个，那么这两个也是一样的，就是结果），
 * 在其基础上把最后剩下的一个数字或者两个回到原来数组中，
 * 将数组遍历一遍统计一下数字出现次数进行最终判断。
 */
public class MoreThanHalfNum_Solution {
    public int moreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        if (n == 0) return 0;

        int num = array[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (array[i] == num) count++;
            else count--;
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }// Verifying
        count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == num) count++;
        }
        if (count * 2 > n) return num;
        return 0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum_Solution m = new MoreThanHalfNum_Solution();
        int i = m.moreThanHalfNum_Solution(new int[]{2, 3, 1, 3, 2, 1,1,1,1,1,1});
        System.out.println(i);
    }
}
