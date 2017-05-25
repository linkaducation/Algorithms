package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/5/7.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class JumpFloor {
    public int count = 0;

    public int jumpFloor(int target) {
        int count1 = 1;
        int count2 = 2;
        int count = 0;
        if (target <= 2) {
            return target;
        } else {
            while (target > 2) {
                count = count2 + count1;
                count1 = count2;
                count2 = count;
                target--;
            }
        }
        return count;


//        if (target == 1 || target == 2) {
//            return target;
//        }
//        int jumpSum = 0;// 当前台阶的跳法总数
//        int jumpSumBackStep1 = 2;// 当前台阶后退一阶的台阶的跳法总数(初始值当前台阶是第3阶)
//        int jumpSumBackStep2 = 1;// 当前台阶后退二阶的台阶的跳法总数(初始值当前台阶是第3阶)
//        for (int i = 3; i <= target; i++) {
//            jumpSum = jumpSumBackStep1 + jumpSumBackStep2;
//            jumpSumBackStep2 = jumpSumBackStep1;// 后退一阶在下一次迭代变为后退两阶
//            jumpSumBackStep1 = jumpSum; // 当前台阶在下一次迭代变为后退一阶
//        }
//
//        return jumpSum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        JumpFloor jf = new JumpFloor();
        System.out.println(jf.jumpFloor(1));
        System.out.println(new JumpFloor().jumpFloor(2));
        System.out.println(new JumpFloor().jumpFloor(3));
        System.out.println(new JumpFloor().jumpFloor(4));
        System.out.println(new JumpFloor().jumpFloor(5));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
