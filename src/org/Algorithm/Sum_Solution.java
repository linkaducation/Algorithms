package org.Algorithm;

/**
 * Created by Ellen on 2017/5/16.
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        int i = execute(n);
        return i;
    }

    private int execute(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += execute(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        Sum_Solution ss= new Sum_Solution();
        System.out.println(ss.execute(10));
    }
}
