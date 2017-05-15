package org.Algorithm;

/**
 * Created by Ellen on 2017/5/15.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length == 1) {
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, sum = 0, index = 0;
        for (int i = 0; i < len; i++) {
            sum ^= array[i];
        }
        for (; index < 32; index++) {
            if ((sum & (1 << index)) != 0) {
                break;
            }
        }
        for (int i = 0; i < len; i ++) {
            if ((array[i] & (1 << index)) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        FindNumsAppearOnce fn = new FindNumsAppearOnce();
        int[] num1 = new int[]{0};
        int[] num2 = new int[]{0};
        fn.FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5},num1,num2);
        System.out.println(num1[0] + " " + num2[0]);
    }
}
