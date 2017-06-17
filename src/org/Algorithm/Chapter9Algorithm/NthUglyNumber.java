package org.Algorithm.Chapter9Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellen on 2017/6/17.
 * 设计一个算法，找出只含素因子2，3，5 的第 n 大的数。
 * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        // Write your code here
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);

        int p2 = 0, p3 = 0, p5 = 0;
        // p2, p3 & p5 share the same queue: uglys

        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            while (uglys.get(p2) * 2 <= lastNumber) p2++;
            while (uglys.get(p3) * 3 <= lastNumber) p3++;
            while (uglys.get(p5) * 5 <= lastNumber) p5++;

            uglys.add(Math.min(
                    Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3),
                    uglys.get(p5) * 5
            ));
        }

        return uglys.get(n - 1);

    }


    public static void main(String[] args) {
        NthUglyNumber nn = new NthUglyNumber();
        int i = nn.nthUglyNumber(6);
        System.out.println(i);
    }
}
