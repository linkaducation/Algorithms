package org.Algorithm;

/**
 * Created by Ellen on 2017/5/17.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3
 */
public class duplicate {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            while (index >= length) {
                index = index - length;
            }
            if (numbers[index] == Integer.MAX_VALUE - index) {
                duplication[0] = numbers[i];
                return true;
            }
            numbers[index] = Integer.MAX_VALUE - index;
        }
        return false;
    }

    public static void main(String[] args) {
        duplicate d = new duplicate();
        int[] result = new int[1];
        boolean b = d.duplicate(new int[]{1, 2, 3, 4, 5, 54, 6, 5, 4, 3, 43, 54}, 12, result);
        System.out.println(b);
        System.out.println(result[0]);
    }
}
