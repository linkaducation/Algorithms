package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/5/12.
 */
public class NowCooderTest {
    public static void main(String[] args) {
        int i;
        i = x(x(8));
        System.out.println(i);
    }

    public static int x(int n){
        if (n <= 3)
            return 1;
        else
            return x(n - 2) + x(n - 4) + 1;
    }
}
