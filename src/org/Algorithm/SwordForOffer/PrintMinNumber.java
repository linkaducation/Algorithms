package org.Algorithm.SwordForOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ellen on 2017/5/12.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] string = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            string[i] = String.valueOf(numbers[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(string, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String r1 = s1 + s2;
                String r2 = s2 + s1;
                return r1.compareTo(r2);
            }
        });
        for (int i = 0; i < string.length; i++) {
            sb.append(string[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber pm = new PrintMinNumber();
        String result = pm.PrintMinNumber(new int[]{321});
        System.out.println(result);
    }
}
