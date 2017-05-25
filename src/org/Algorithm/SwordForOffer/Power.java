package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/5/8.
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
    public double power(double base, int exponent) {
//        double bases = 1;
//        if (exponent > 0){
//            for (int i = 0; i < Math.abs(exponent); i++){
//                bases = bases*base;
//            }
//            return bases;
//        }else {
//            for (int i = 0; i < Math.abs(exponent); i++){
//                bases = bases*base;
//            }
//            return 1/bases;
//        }
        int n = Math.abs(exponent);
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else {
            double result = power(base, n >> 1);
            result *= result;
            if ((n & 1) == 1) {
                result *= base;
            }
            if (exponent < 0){
                return 1/result;
            }
            return result;
        }
    }
}
