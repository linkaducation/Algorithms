package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/5/16.
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str == null || str == "") {
            return 0;
        }
        int k = 0;
        int count = 0;
        char[] array = str.toCharArray();
        int len = array.length - 1;
        for (int i = len; i >= 0; i--) {
            if (i == 0) {
                if (array[i] == '-') {
                    k = -1;
                    break;
                }
                if (array[i] == '+') {
                    k = 1;
                    break;
                }
            }
            int temp = array[i] - '0';
            if (temp >= 0 && temp <= 9) {
                if (i == len) {
                    count += temp;
                } else {
                    temp *= (int) Math.pow(10, len - i);
                    count += temp;
                }
            } else {
                return 0;
            }
        }
        if (k != 0) {
            count *= k;
        }
        return count;
    }

    public static void main(String[] args) {
        StrToInt st = new StrToInt();
        int i = st.StrToInt("+111");
        System.out.println(i);
    }
}
