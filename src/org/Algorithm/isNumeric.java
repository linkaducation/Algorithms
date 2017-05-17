package org.Algorithm;

/**
 * Created by Ellen on 2017/5/17.
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class isNumeric {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length <= 0) {
            return false;
        }
        int len = str.length - 1;
        boolean isE = false;
        boolean isD = false;
        for (int i = 0; i <= len; i++) {
            if (i == 0 && (str[i] == '+' || str[i] == '-')) {
                if (i < len && str[i + 1] == '.') {
                    isD = true;
                    i++;
                    continue;
                }
                continue;
            }
            if (i == len && (str[i] == '+' || str[i] == '-')) {
                return false;
            }
            if (str[i] >= '0' && str[i] <= '9') {
                continue;
            }
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == len || i == 0) {
                    return false;
                }
                if (isE) {
                    return false;
                } else {
                    isE = true;
                    isD = true;
                    continue;
                }
            }
            if (str[i] == '-' || str[i] == '+') {
                if (str[i - 1] == 'e' || str[i - 1] == 'E') {
                    continue;
                } else {
                    return false;
                }
            }
            if (str[i] == '.') {
                if (!isE) {
                    isD = true;
                }
                if (isD) {
                    return false;
                }
                if (isE) {
                    if (isD)
                        return false;
                }
                if (i == len) {
                    return false;
                } else if (i == 0) {
                    isD = true;
                    continue;
                } else if (str[i - 1] == 'e' || str[i + 1] == 'e' || str[i + 1] == '+' || str[i + 1] == '-') {
                    return false;
                }
                continue;
            }
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isNumeric in = new isNumeric();
        String s = "1.2.3";
        char[] array = s.toCharArray();
        boolean numeric = in.isNumeric(array);
        System.out.println(numeric);
    }
}
