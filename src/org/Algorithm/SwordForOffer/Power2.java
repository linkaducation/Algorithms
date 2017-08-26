package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/8/23.
 */
public class Power2 {

    public static void main(String[] args) {
        double power = Power(2.5, 5);
        System.out.println(power);
    }

    public static double Power(double base, int exponent) {
        double res = 1, n = exponent;
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为0");
            }
            n = -exponent;
        }
        while (n > 0) {
            res *= base;
            n--;
        }
        return exponent > 0 ? res : 1 / res;
    }
}
