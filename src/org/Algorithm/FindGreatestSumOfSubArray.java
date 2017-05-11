package org.Algorithm;

/**
 * Created by Ellen on 2017/5/11.
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,
 * 是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int sum = -111111111;
        int tempSum = array[0];
        for (int i = 1; i < array.length; i++) {
            tempSum = tempSum < 0 ? array[i] : tempSum + array[i];
            sum = tempSum > sum ? tempSum : sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray fgss = new FindGreatestSumOfSubArray();
        int sum = fgss.FindGreatestSumOfSubArray(new int[]{-100, 2, 2, 0, 0, 0, 3, 3, 1});
        System.out.println(sum);
    }
}
